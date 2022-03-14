package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.command.AgregarAsesoria;
import domain.centrodeasesoria.command.AgregarIngeniero;
import domain.centrodeasesoria.event.AsesoriaAgregada;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.centrodeasesoria.value.AsesoriaID;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.centrodeasesoria.value.IngenieroID;
import domain.tallerdediseno.command.AgregarDiseno;
import domain.tallerdediseno.event.DisenoAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;
import domain.value.Dimensiones;
import domain.value.Idea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarAsesoriaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarAsesoria(){
        //arrange
        CentroDeAsesoriaID centroDeAsesoriaID =  CentroDeAsesoriaID.of("centro");
        AsesoriaID asesoriaID = AsesoriaID.of("asesoria");

        Dimensiones dimensiones=new Dimensiones();
        Idea idea = new Idea("idea",dimensiones,"idea");

        var command = new AgregarAsesoria(centroDeAsesoriaID,asesoriaID,idea,"Obtener producto Funcional");

        var usecase = new AgregarAsesoriaUseCase();
        Mockito.when(repository.getEventsBy("centro")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(centroDeAsesoriaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asert

        var event = (AsesoriaAgregada) events.get(0);
        Assertions.assertEquals("Centrodeasesoria.asesoriaagregada",event.type);
        Assertions.assertEquals("asesoria",event.getAsesoriaId().value());
        Assertions.assertEquals("Obtener producto Funcional",event.getEspectativasIdea());
        Assertions.assertEquals(idea,event.getIdea());

    }

    private List<DomainEvent> history() {
        CentroDeAsesoriaID centroDeAsesoriaID=CentroDeAsesoriaID.of("taller");
        return List.of(new CentroDeAsesoriaCreado(centroDeAsesoriaID));
    }

}
package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.command.AgregarIngeniero;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.centrodeasesoria.event.IngenieroAgregado;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.centrodeasesoria.value.IngenieroID;
import domain.value.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarIngenieroUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarIngeniero() {
        //arrange
        CentroDeAsesoriaID centroDeAsesoriaID = CentroDeAsesoriaID.of("centro");
        IngenieroID ingenieroID = IngenieroID.of("ingeniero");
        Persona persona = new Persona("alvaro", "mena", "123456789");
        var command = new AgregarIngeniero(centroDeAsesoriaID, ingenieroID, persona, 5);

        var usecase = new AgregarIngenieroUseCase();
        Mockito.when(repository.getEventsBy("centro")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(centroDeAsesoriaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert

        var event = (IngenieroAgregado) events.get(0);
        Assertions.assertEquals("centrodeasesoria.ingenieroagregado",event.type);
        Assertions.assertEquals("ingeniero",event.getIngenieroID().value());
        Assertions.assertEquals(persona,event.getPersona());
        Assertions.assertEquals(5,event.getNumeroDeAsesoriasEnSimultaneo());
    }

    private List<DomainEvent> history() {
        CentroDeAsesoriaID centroDeAsesoriaID=CentroDeAsesoriaID.of("centro");
        return List.of(new CentroDeAsesoriaCreado(centroDeAsesoriaID));
    }
}
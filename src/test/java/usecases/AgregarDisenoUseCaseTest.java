package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.AgregarDisenador;
import domain.tallerdediseno.command.AgregarDiseno;
import domain.tallerdediseno.event.DisenoAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;
import domain.value.Dimensiones;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarDisenoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDiseno(){
        //arrange
        TallerDeDisenoID tallerDeDisenoID = TallerDeDisenoID.of("taller");
        DisenoID disenoID = DisenoID.of("diseño");
        Dimensiones dimensiones=new Dimensiones();
        Boceto boceto = new Boceto("bocetico","detalles",dimensiones);

        var command = new AgregarDiseno(tallerDeDisenoID,disenoID,boceto,"muy bonita");

        var usecase = new AgregarDisenoUseCase();
        Mockito.when(repository.getEventsBy("taller")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tallerDeDisenoID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asert

        var event = (DisenoAgregadado) events.get(0);
        Assertions.assertEquals("tallerdediseno.disenoagregado",event.type);
        Assertions.assertEquals("diseño",event.getDicenoID().value());
        Assertions.assertEquals("muy bonita",event.getComentariosDeBoceto());
        Assertions.assertEquals(boceto,event.getBoceto());
    }

    private List<DomainEvent> history() {
        TallerDeDisenoID tallerDeDisenoID=TallerDeDisenoID.of("taller");
        return List.of(new TallerDeDisenoCreado(tallerDeDisenoID));
    }
}
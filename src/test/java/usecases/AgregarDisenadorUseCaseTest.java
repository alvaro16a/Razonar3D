package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.AgregarDisenador;
import domain.tallerdediseno.event.DisenadorAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenadorID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarDisenadorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDisenador() {
        //arrange
        TallerDeDisenoID tallerDeDisenoID = TallerDeDisenoID.of("taller");
        DisenadorID disenadorID = DisenadorID.of("diseñador");
        Persona persona = new Persona("alvaro", "mena", "123456789");
        var command = new AgregarDisenador(tallerDeDisenoID, disenadorID, persona, 5);

        var usecase = new AgregarDisenadorUseCase();
        Mockito.when(repository.getEventsBy("taller")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tallerDeDisenoID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asert

        var event = (DisenadorAgregadado) events.get(0);
        Assertions.assertEquals("tallerdediseno.disenadoragregado",event.type);
        Assertions.assertEquals("diseñador",event.getDisenadorID().value());
        Assertions.assertEquals(persona,event.getPersona());
        Assertions.assertEquals(5,event.getNumeroDeProyectosEnSimultaneo().intValue());
    }
        private List<DomainEvent> history() {
            TallerDeDisenoID tallerDeDisenoID=TallerDeDisenoID.of("taller");
            return List.of(new TallerDeDisenoCreado(tallerDeDisenoID));
        }
}

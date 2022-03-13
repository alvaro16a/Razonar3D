package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.command.CrearTrabajo;
import domain.cliente.event.ClienteNaturalCreado;
import domain.cliente.event.TrabajoCreado;
import domain.cliente.value.*;
import domain.value.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearTrabajoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearTrabajo(){
        //arrange

        ClienteID clienteID = ClienteID.of("cliente");
        TrabajoID trabajoID = TrabajoID.of("Maqueta");
        Fase faseInicial = new Fase(Fase.Etapa.FABRICACION);
        Tipo tipo = new Tipo(faseInicial,faseInicial);
        var command = new CrearTrabajo(clienteID,trabajoID,tipo);

        var usecase= new CrearTrabajoUseCase();
        Mockito.when(repository.getEventsBy("cliente")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);

        //act

        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(clienteID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert

        var event = (TrabajoCreado) events.get(0);
        Assertions.assertEquals("cliente.trabajocreado",event.type);
        Assertions.assertEquals("Maqueta",event.getTrabajoID().value());
        Assertions.assertEquals(tipo,event.getTipo());

    }

    private List<DomainEvent> history() {
        Persona persona= new Persona("Alvaro","Mena","1234");
        InformacionDeContacto contacto=new InformacionDeContacto("Bello","8282844","alvaro16a@gmail.com");
        return List.of(new ClienteNaturalCreado(persona,contacto));
    }

}
package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.granja.Encargado;
import domain.tallerdediseno.command.granja.command.AgregarImpresion;
import domain.tallerdediseno.command.granja.event.GranjaCreada;
import domain.tallerdediseno.command.granja.event.ImpresionIncluida;
import domain.tallerdediseno.command.granja.value.EncargadoID;
import domain.tallerdediseno.command.granja.value.GranjaID;
import domain.value.Persona;
import domain.value.Stl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AgregarImpresionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarImpresion(){


        //arrange

        GranjaID granjaID = GranjaID.of("migranjita");
        Stl stl =new Stl("avion",9);
        Stl stl2 =new Stl("barco",9);
        var command = new AgregarImpresion(granjaID,stl);
        var usecase= new AgregarImpresionUseCase();
        Mockito.when(repository.getEventsBy("migranjita")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);
        //act

        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(granjaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asert

        var event = (ImpresionIncluida) events.get(0);
        Assertions.assertEquals("granja.impresionincluida",event.type);
        //Assertions.assertEquals(stl2,event.getStl()); Falla por que lo compare con otro stl
        Assertions.assertEquals(stl,event.getStl());
    }

    private List<DomainEvent> history() {
        Persona persona= new Persona("Alvaro","Mena","1234");
        Encargado encargado = new Encargado(EncargadoID.of("encargado"),persona,8);
        return List.of(new GranjaCreada(encargado));
    }
}
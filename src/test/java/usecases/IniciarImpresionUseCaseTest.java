package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.Encargado;
import domain.granja.Granja;
import domain.granja.command.AgregarImpresora3D;
import domain.granja.command.IniciarImpresion;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresionIniciada;
import domain.granja.event.ImpresoraIncluida;
import domain.granja.value.EncargadoID;
import domain.granja.value.GranjaID;
import domain.granja.value.ImpresoraID;
import domain.value.Persona;
import domain.value.Stl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IniciarImpresionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void iniciarImpresion() {

        //arrange

        GranjaID granjaID = GranjaID.of("migranjita");
        ImpresoraID impresoraID = ImpresoraID.of("mimpresora");
        var command = new IniciarImpresion(granjaID,impresoraID);


        var usecase= new IniciarImpresionUseCase();
        Mockito.when(repository.getEventsBy("migranjita")).thenReturn(history());  //le estoy dando la simulacion al mock
        usecase.addRepository(repository);
        //act

        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(granjaID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert

        var event = (ImpresionIniciada) events.get(0);
        Assertions.assertEquals("granja.impresoraincluida",event.type);

    }

    private List<DomainEvent> history() {
        Persona persona= new Persona("Alvaro","Mena","1234");
        Encargado encargado = new Encargado(EncargadoID.of("encargado"),persona,10);
        return List.of(
                        new GranjaCreada(encargado)
        );
    }

}

















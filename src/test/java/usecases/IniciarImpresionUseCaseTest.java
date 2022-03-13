package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.Encargado;
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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IniciarImpresionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void iniciarImpresion(){
        //arrange
        GranjaID granjaID = GranjaID.of("migranjita");
        ImpresoraID impresoraID = ImpresoraID.of("123");
        var command = new IniciarImpresion(granjaID,impresoraID);

        var usecase = new IniciarImpresionUseCase();
        Mockito.when(repository.getEventsBy("migranjita")).thenReturn(history());
        usecase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert

        var event = (ImpresionIniciada) events.get(0);

    }

    private List<DomainEvent> history() {

        Persona persona= new Persona("Alvaro","Mena","1234");
        Encargado encargado = new Encargado(EncargadoID.of("encargado"),persona,2);
        Stl stl=new Stl("casa",5);
        return List.of(
                new GranjaCreada(encargado),
                new ImpresoraIncluida(ImpresoraID.of("123")),
                new ImpresionIncluida(stl),
                new ImpresionIncluida(stl)
        );
    }
}
package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.centrodeasesoria.CentroDeAsesoria;
import domain.centrodeasesoria.command.CrearCentroDeAsesoria;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCentroDeAsesoriaUseCaseTest {

    @Test
    void crearCentroDeAsesoria(){

        //arrange
        var command= new CrearCentroDeAsesoria(CentroDeAsesoriaID.of("centro"));
        var usecase= new CrearCentroDeAsesoriaUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();

        //asert

        var event = (CentroDeAsesoriaCreado)events.get(0);
        Assertions.assertEquals("centrodeasesoria.creado",event.type);
        Assertions.assertEquals("centro",event.getCentroDeAsesoriaID().value());

    }

}
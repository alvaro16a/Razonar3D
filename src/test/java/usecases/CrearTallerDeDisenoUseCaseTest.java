package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.tallerdediseno.command.CrearTallerDeDiseno;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.TallerDeDisenoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearTallerDeDisenoUseCaseTest {

    @Test
    void crearTallerDeDiseno(){

        //arrange
        TallerDeDisenoID tallerDeDisenoID = TallerDeDisenoID.of("taller");

        var command = new CrearTallerDeDiseno(tallerDeDisenoID);
        var usecase= new CrearTallerDeDisenoUseCase();
        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();

        //asert

        var event = (TallerDeDisenoCreado)events.get(0);
        Assertions.assertEquals("tallerdediseno.creado",event.type);//garantizo el tipo del evento
        Assertions.assertEquals("taller",event.getTallerDeDisenoID().value());

    }


}
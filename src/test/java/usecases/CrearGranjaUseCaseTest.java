package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.tallerdediseno.command.granja.Encargado;
import domain.tallerdediseno.command.granja.command.CrearGranja;
import domain.tallerdediseno.command.granja.event.GranjaCreada;
import domain.tallerdediseno.command.granja.value.EncargadoID;
import domain.tallerdediseno.command.granja.value.GranjaID;
import domain.value.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearGranjaUseCaseTest {

    @Test
    void crearGranja(){

        //arrange
        GranjaID granjaID = GranjaID.of("valor"); //de esta forma se crea un id quemado por el usuario
        Persona persona= new Persona("Alvaro","Mena","1234");

        Encargado encargado = new Encargado(EncargadoID.of("encargado"),persona,8);
        var command = new CrearGranja(granjaID,encargado);
        var usecase= new CrearGranjaUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();
        //asert
        var event = (GranjaCreada)events.get(0);
        Assertions.assertEquals("granja.granjacreada",event.type);//garantizo el tipo del evento
        Assertions.assertEquals(encargado,event.getEncargado());//de esta forma garantizo que el encargado sea el correcto

    }

}
package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cliente.command.CrearClienteJuridico;
import domain.cliente.command.CrearClienteNatural;
import domain.cliente.event.ClienteJuridicoCreado;
import domain.cliente.event.ClienteNaturalCreado;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;
import domain.value.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearClienteNaturalUseCaseTest {

    @Test
    void crearClienteNatural(){

        //arrange
        ClienteID clienteID = ClienteID.of("valor"); //de esta forma se crea un id quemado por el usuario
        Persona persona = new Persona("alvaro","Mena","123456789");
        InformacionDeContacto contacto=new InformacionDeContacto("santa Ana","8282844","alvaro16a@gmail.com");

        var command = new CrearClienteNatural(clienteID,persona,contacto);
        var usecase= new CrearClienteNaturalUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();
        //asert
        var event = (ClienteNaturalCreado)events.get(0);
        Assertions.assertEquals("cliente.clientenaturalcreado",event.type);//garantizo el tipo del evento
        Assertions.assertEquals("alvaro",event.getPersona().getNombre());
        Assertions.assertEquals(contacto,event.getContacto());
    }

}
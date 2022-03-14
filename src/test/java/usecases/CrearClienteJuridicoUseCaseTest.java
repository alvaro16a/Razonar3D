package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cliente.command.CrearClienteJuridico;
import domain.cliente.event.ClienteJuridicoCreado;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearClienteJuridicoUseCaseTest {

    @Test
    void crearClienteJuridico(){

        //arrange
        ClienteID clienteID = ClienteID.of("valor"); //de esta forma se crea un id quemado por el usuario
        Empresa empresa = new Empresa("sofka","800.197.268-4");
        InformacionDeContacto contacto=new InformacionDeContacto("santa Ana","8282844","alvaro16a@gmail.com");

        var command = new CrearClienteJuridico(clienteID,empresa,contacto);
        var usecase= new CrearClienteJuridicoUseCase();
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();
        //asert
        var event = (ClienteJuridicoCreado)events.get(0);
        Assertions.assertEquals("cliente.clientejuridicocreado",event.type);//garantizo el tipo del evento
        Assertions.assertEquals(empresa,event.getEmpresa());
        Assertions.assertEquals(contacto,event.getContacto());
    }

}
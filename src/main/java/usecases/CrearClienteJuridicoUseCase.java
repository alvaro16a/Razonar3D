package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.command.CrearClienteJuridico;


public class CrearClienteJuridicoUseCase extends UseCase<RequestCommand<CrearClienteJuridico>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearClienteJuridico> crearClienteJuridicoRequestCommand) {

        var command = crearClienteJuridicoRequestCommand.getCommand(); //Extraigo el comando del envoltorio
        var cliente =new Cliente(command.getClienteID(),command.getEmpresa(),command.getContacto());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges())); //emito los cambios que no han sido confirmado del agregado
    }
}

package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.command.CrearClienteJuridico;
import domain.cliente.command.CrearClienteNatural;

public class CrearClienteNaturalUseCase extends UseCase<RequestCommand<CrearClienteNatural>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClienteNatural> crearClienteNaturalRequestCommand) {

        var command = crearClienteNaturalRequestCommand.getCommand();
        var cliente = new Cliente(command.getClienteID(), command.getPersona(), command.getContacto());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges())); //emito los cambios que no han sido confirmado del agregado
    }
}

package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cliente.Cliente;
import domain.cliente.command.CrearTrabajo;

public class CrearTrabajoUseCase extends UseCase<RequestCommand<CrearTrabajo>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearTrabajo> input) {
        var command = input.getCommand();

        var cliente = Cliente.from(command.getClienteID(),retrieveEvents());
        cliente.crearTrabajo(command.getTrabajoID(),command.getTipo());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}

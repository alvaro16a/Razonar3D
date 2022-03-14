package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.CrearTallerDeDiseno;

public class CrearTallerDeDisenoUseCase extends UseCase<RequestCommand<CrearTallerDeDiseno>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTallerDeDiseno> crearTallerDeDisenoRequestCommand) {

        var command =  crearTallerDeDisenoRequestCommand.getCommand(); //Extraigo el comando del envoltorio
        var tallerDediseno = new TallerDeDiseno(command.getTallerDeDisenoID());
        emit().onResponse(new ResponseEvents(tallerDediseno.getUncommittedChanges())); //emito los cambios que no han sido confirmado del agregado

    }
}

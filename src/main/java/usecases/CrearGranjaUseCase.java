package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.granja.Granja;
import domain.granja.command.CrearGranja;

public class CrearGranjaUseCase extends UseCase<RequestCommand<CrearGranja>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearGranja> crearGranjaRequestCommand) {

        var command = crearGranjaRequestCommand.getCommand(); //Extraigo el comando del envoltorio
        var granja =new Granja(command.getGranjaID(),command.getEncargado());
        emit().onResponse(new ResponseEvents(granja.getUncommittedChanges())); //emito los cambios que no han sido confirmado del agregado
    }

}

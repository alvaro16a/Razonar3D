package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.centrodeasesoria.CentroDeAsesoria;
import domain.centrodeasesoria.command.CrearCentroDeAsesoria;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.CrearTallerDeDiseno;

public class CrearCentroDeAsesoriaUseCase extends UseCase<RequestCommand<CrearCentroDeAsesoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCentroDeAsesoria> input) {

        var command =  input.getCommand(); //Extraigo el comando del envoltorio
        var centroDeAsesoria = new CentroDeAsesoria(command.getCentroDeAsesoriaID());
        emit().onResponse(new ResponseEvents(centroDeAsesoria.getUncommittedChanges())); //emito los cambios que no han sido confirmado del agregado
    }
}

package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.granja.Granja;
import domain.granja.command.AgregarImpresora3D;

public class AgregarImpresora3DUseCase extends UseCase<RequestCommand<AgregarImpresora3D>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarImpresora3D> input) {
        var command=input.getCommand(); //En este comando el agregado ya existe por lo cual debemos poder reconstruir la granja con el ID y los eventos

        var granja = Granja.from(command.getGranjaID(),retrieveEvents());
        granja.agregarImpresora3D(command.getImpresoraID());
        emit().onResponse(new ResponseEvents(granja.getUncommittedChanges())); //emito los cambios que aun no han sido confirmados
    }
}

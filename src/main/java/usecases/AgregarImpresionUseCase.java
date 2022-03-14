package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tallerdediseno.command.granja.Granja;
import domain.tallerdediseno.command.granja.command.AgregarImpresion;

public class AgregarImpresionUseCase extends UseCase<RequestCommand<AgregarImpresion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarImpresion> input) {

        var command=input.getCommand(); //En este comando el agregado ya existe por lo cual debemos poder reconstruir la granja con el ID y los eventos
        var granja = Granja.from(command.getGranjaID(),retrieveEvents());
        granja.agregarImpresion(command.getStl());
        emit().onResponse(new ResponseEvents(granja.getUncommittedChanges())); //emito los cambios que aun no han sido confirmados

    }
}

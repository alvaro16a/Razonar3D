package usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.granja.Granja;
import domain.granja.command.AgregarImpresora3D;
import domain.granja.command.IniciarImpresion;

public class IniciarImpresionUseCase extends UseCase<RequestCommand<IniciarImpresion>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<IniciarImpresion> input) {
        var command=input.getCommand();

        var granja = Granja.from(command.getGranjaID(),retrieveEvents());
        granja.iniciarImpresion(command.getImpresoraID());
        emit().onResponse(new ResponseEvents(granja.getUncommittedChanges()));
    }
}

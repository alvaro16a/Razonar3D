package usecases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.AgregarDiseñador;

public class AgregarDisenadorUseCase extends UseCase<RequestCommand<AgregarDiseñador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDiseñador> agregarDiseñadorRequestCommand) {
        var command= agregarDiseñadorRequestCommand.getCommand();

        var tallerDeDiseno = TallerDeDiseno.from(command.getTallerDeDisenoID(),retrieveEvents());
        tallerDeDiseno.agregarDiseñador(command.getDisenadorID(),command.getPersona(),command.getNumeroDeProyectosEnSimultaneo());
        emit().onResponse(new ResponseEvents(tallerDeDiseno.getUncommittedChanges()));
    }
}

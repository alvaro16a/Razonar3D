package usecases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.AgregarDisenador;
import domain.tallerdediseno.command.AgregarDiseno;

public class AgregarDisenoUseCase extends UseCase<RequestCommand<AgregarDiseno>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDiseno> agregarDisenoRequestCommand) {
        var command= agregarDisenoRequestCommand.getCommand();

        var tallerDeDiseno = TallerDeDiseno.from(command.getTallerDeDisenoID(),retrieveEvents());
        tallerDeDiseno.agregarDiseno(command.getDisenoID(),command.getBoceto(),command.getComentariosDeBoceto());
        emit().onResponse(new ResponseEvents(tallerDeDiseno.getUncommittedChanges()));
    }
}

package usecases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.centrodeasesoria.CentroDeAsesoria;
import domain.centrodeasesoria.command.AgregarAsesoria;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.AgregarDiseno;

public class AgregarAsesoriaUseCase extends UseCase<RequestCommand<AgregarAsesoria>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarAsesoria> input) {
        var command= input.getCommand();

        var centroDeAsesoria = CentroDeAsesoria.from(command.getCentroDeAsesoriaID(),retrieveEvents());
        centroDeAsesoria.agregarAsesoria(command.getAsesoriaID(),command.getIdea(),command.getEspectativasIdea());
        emit().onResponse(new ResponseEvents(centroDeAsesoria.getUncommittedChanges()));
    }
}

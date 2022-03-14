package usecases;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.centrodeasesoria.CentroDeAsesoria;
import domain.centrodeasesoria.command.AgregarIngeniero;
import domain.tallerdediseno.TallerDeDiseno;
import domain.tallerdediseno.command.AgregarDisenador;

public class AgregarIngenieroUseCase extends UseCase<RequestCommand<AgregarIngeniero>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarIngeniero> input) {
        var command= input.getCommand();

        var centroDeAsesoria = CentroDeAsesoria.from(command.getCentroDeAsesoriaID(),retrieveEvents());
        centroDeAsesoria.agregarIngeniero(command.getIngenieroID(),command.getPersona(),command.getNumeroDeAsesoriasEnSimultaneo());
        emit().onResponse(new ResponseEvents(centroDeAsesoria.getUncommittedChanges()));
    }
}

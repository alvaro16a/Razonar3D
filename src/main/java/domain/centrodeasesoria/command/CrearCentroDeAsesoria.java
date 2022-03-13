package domain.centrodeasesoria.command;

import co.com.sofka.domain.generic.Command;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.tallerdediseno.value.TallerDeDisenoID;

public class CrearCentroDeAsesoria extends Command {

    private final CentroDeAsesoriaID centroDeAsesoriaID;


    public CrearCentroDeAsesoria(CentroDeAsesoriaID centroDeAsesoriaID) {
        this.centroDeAsesoriaID = centroDeAsesoriaID;
    }

    public CentroDeAsesoriaID getCentroDeAsesoriaID() {
        return centroDeAsesoriaID;
    }
}

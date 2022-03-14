package domain.centrodeasesoria.command;

import co.com.sofka.domain.generic.Command;
import domain.centrodeasesoria.value.AsesoriaID;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;
import domain.value.Idea;

public class AgregarAsesoria extends Command {

    private  final CentroDeAsesoriaID centroDeAsesoriaID;
    private  final AsesoriaID asesoriaID;
    private  final Idea idea;
    private  final String espectativasIdea;

    public AgregarAsesoria(CentroDeAsesoriaID centroDeAsesoriaID, AsesoriaID entityId, Idea idea, String espectativasIdea) {
        this.centroDeAsesoriaID=centroDeAsesoriaID;
        this.asesoriaID=entityId;
        this.idea=idea;
        this.espectativasIdea = espectativasIdea;
    }

    public CentroDeAsesoriaID getCentroDeAsesoriaID() {
        return centroDeAsesoriaID;
    }

    public AsesoriaID getAsesoriaID() {
        return asesoriaID;
    }

    public Idea getIdea() {
        return idea;
    }

    public String getEspectativasIdea() {
        return espectativasIdea;
    }

}

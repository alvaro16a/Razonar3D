package domain.centrodeasesoria.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.value.AsesoriaID;
import domain.value.Idea;

import java.util.UUID;

public class AsesoriaAgregada extends DomainEvent {
    private final AsesoriaID asesoriaId;
    private final Idea idea;
    private final String espectativasIdea;

    public AsesoriaAgregada(AsesoriaID entityId, Idea idea, String espectativasIdea) {
        super("Centrodeasesoria.asesoriaagregada");
        this.asesoriaId = entityId;
        this.idea = idea;
        this.espectativasIdea = espectativasIdea;
    }

    public AsesoriaID getAsesoriaId() {
        return asesoriaId;
    }

    public Idea getIdea() {
        return idea;
    }

    public String getEspectativasIdea() {
        return espectativasIdea;
    }
}

package domain.centrodeasesoria.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.value.IngenieroID;
import domain.value.Persona;

public class IngenieroAgregado extends DomainEvent {

    private final IngenieroID ingenieroID;
    private final Persona persona;
    private final int numeroDeAsesoriasEnSimultaneo;

    public IngenieroAgregado(IngenieroID ingenieroID, Persona persona, int numeroDeAsesoriasEnSimultaneo) {
        super("centrodeasesoria.ingenieroagregado");
        this.ingenieroID=ingenieroID;
        this.persona=persona;
        this.numeroDeAsesoriasEnSimultaneo=numeroDeAsesoriasEnSimultaneo;
    }

    public IngenieroID getIngenieroID() {
        return ingenieroID;
    }

    public Persona getPersona() {
        return persona;
    }

    public int getNumeroDeAsesoriasEnSimultaneo() {
        return numeroDeAsesoriasEnSimultaneo;
    }
}

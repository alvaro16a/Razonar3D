package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.value.Tipo;
import domain.cliente.value.TrabajoID;
import domain.value.Idea;

public class TrabajoCreado extends DomainEvent {

    private final TrabajoID trabajoID;
    private final Idea idea;
    private final Tipo tipo;

    public TrabajoCreado(TrabajoID trabajoID, Idea idea, Tipo tipo) {
        super("cilente.trabajocreado");
        this.trabajoID = trabajoID;
        this.idea = idea;
        this.tipo = tipo;
    }

    public TrabajoID getTrabajoID() {
        return trabajoID;
    }

    public Idea getIdea() {
        return idea;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

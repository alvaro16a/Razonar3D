package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.value.Tipo;
import domain.cliente.value.TrabajoID;
import domain.value.Idea;

public class TrabajoCreado extends DomainEvent {

    private final TrabajoID trabajoID;
    private final Tipo tipo;

    public TrabajoCreado(TrabajoID trabajoID, Tipo tipo) {
        super("cliente.trabajocreado");
        this.trabajoID = trabajoID;
        this.tipo = tipo;
    }

    public TrabajoID getTrabajoID() {
        return trabajoID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

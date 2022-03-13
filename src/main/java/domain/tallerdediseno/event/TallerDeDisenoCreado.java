package domain.tallerdediseno.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.Disenador;
import domain.tallerdediseno.value.TallerDeDisenoID;

public class TallerDeDisenoCreado extends DomainEvent {

    private final TallerDeDisenoID tallerDeDisenoID;

    public TallerDeDisenoCreado( TallerDeDisenoID entityId) {
        super("tallerdediseno.creado");
        this.tallerDeDisenoID=entityId;

    }

    public TallerDeDisenoID getTallerDeDisenoID() {
        return tallerDeDisenoID;
    }
}

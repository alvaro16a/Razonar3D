package domain.tallerdediseno.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.Disenador;

public class TallerDeDisenoCreado extends DomainEvent {

    private final Disenador disenador;

    public TallerDeDisenoCreado(Disenador disenador) {
        super("tallerdediseno.creado");
        this.disenador=disenador;
    }

    public Disenador getDisenador() {
        return disenador;
    }
}

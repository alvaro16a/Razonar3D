package domain.tallerdediseno.command.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.value.Stl;

public class ImpresionIncluida extends DomainEvent {

    private final Stl stl;

    public ImpresionIncluida(Stl stl) {
        super("granja.impresionincluida");
        this.stl=stl;
    }

    public Stl getStl() {
        return stl;
    }

}

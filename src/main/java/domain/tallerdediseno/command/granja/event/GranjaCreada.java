package domain.tallerdediseno.command.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.granja.Encargado;

public class GranjaCreada extends DomainEvent {

    private final Encargado encargado;

    public GranjaCreada(Encargado encargado) {
        super("granja.granjacreada");
        this.encargado=encargado;
    }

    public Encargado getEncargado() {
        return encargado;
    }
}

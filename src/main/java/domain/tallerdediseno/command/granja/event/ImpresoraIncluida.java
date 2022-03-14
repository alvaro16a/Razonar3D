package domain.tallerdediseno.command.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.granja.value.ImpresoraID;

public class ImpresoraIncluida extends DomainEvent {

    private final ImpresoraID impresoraID;

    public ImpresoraIncluida(ImpresoraID impresoraID) {
        super("granja.impresoraincluida");
        this.impresoraID = impresoraID;
    }

    public ImpresoraID getImpresoraID() {
        return impresoraID;
    }
}

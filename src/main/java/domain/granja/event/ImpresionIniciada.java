package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.value.ImpresoraID;

public class ImpresionIniciada extends DomainEvent {

    private final ImpresoraID impresoraID;

    public ImpresionIniciada(ImpresoraID impresoraID) {
        super("granja.impresioniniciada");
        this.impresoraID = impresoraID;
    }

    public ImpresoraID getImpresoraID() {
        return impresoraID;
    }
}

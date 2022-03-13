package domain.granja.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.Encargado;
import domain.granja.value.GranjaID;

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

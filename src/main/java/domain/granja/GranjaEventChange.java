package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;

import java.util.ArrayList;
import java.util.HashMap;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {

            granja.encargado = event.getEncargado();
            granja.impresoras = new HashMap<>();
            granja.stls = new ArrayList<>();

        });
    }
}

package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresoraIncluida;

import java.util.ArrayList;
import java.util.HashMap;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {

            granja.encargado = event.getEncargado();
            granja.impresoras = new HashMap<>();
            granja.stls = new ArrayList<>();

        });

        apply((ImpresoraIncluida event) ->{
            granja.impresoras.put(event.getImpresoraID().value(),//convierto el Id en la llave
                    new Impresora3D(event.getImpresoraID()));
        });

        apply((ImpresionIncluida event) ->{
            granja.stls.add(event.getStl());
        });
    }
}

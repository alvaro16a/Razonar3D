package domain.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.granja.event.GranjaCreada;
import domain.granja.value.GranjaID;
import domain.value.Stl;

import java.util.List;
import java.util.Map;

public class Granja extends AggregateEvent<GranjaID> {

    protected Encargado encargado;
    protected Map<String,Impresora3D> impresoras;
    protected List<Stl> stls;

    public Granja(GranjaID entityId, Encargado encargado) {
        super(entityId);
        appendChange(new GranjaCreada(encargado)).apply();
        subscribe(new GranjaEventChange(this)); //Para realizar un cambio en el estado debo suscribirla
    }
}

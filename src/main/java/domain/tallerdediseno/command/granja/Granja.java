package domain.tallerdediseno.command.granja;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.command.granja.event.GranjaCreada;
import domain.tallerdediseno.command.granja.event.ImpresionIncluida;
import domain.tallerdediseno.command.granja.event.ImpresionIniciada;
import domain.tallerdediseno.command.granja.event.ImpresoraIncluida;
import domain.tallerdediseno.command.granja.value.GranjaID;
import domain.tallerdediseno.command.granja.value.ImpresoraID;
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

    private Granja(GranjaID granjaID) {
        super(granjaID);
        subscribe(new GranjaEventChange(this));
    }

    public static Granja from(GranjaID id, List<DomainEvent> events){ //reconstruccion de la granja teniendo id y eventos
        var granja = new Granja(id);
        events.forEach(granja::applyEvent);
        return granja;
    }

    public void agregarImpresora3D(ImpresoraID entityId){
        appendChange(new ImpresoraIncluida(entityId)).apply();
    }
    public void agregarImpresion(Stl stl){appendChange(new ImpresionIncluida(stl)).apply(); }
    public void iniciarImpresion(ImpresoraID entityId){appendChange(new ImpresionIniciada(entityId)).apply();}
}

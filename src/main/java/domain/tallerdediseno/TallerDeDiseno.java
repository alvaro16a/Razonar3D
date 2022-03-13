package domain.tallerdediseno;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;

import java.util.List;
import java.util.Map;

public class TallerDeDiseno extends AggregateEvent<TallerDeDisenoID> {

    protected Map<String, Diseno> diseños;
    protected Map<String, Disenador> diseñadores;
    protected List<Boceto> bocetos;

    public TallerDeDiseno(TallerDeDisenoID entityId,Disenador disenador) {
        super(entityId);
        //appendChange(new TallerDeDisenoCreado(disenador)).apply();
    }
/*
    private TallerDeDiseno(TallerDeDisenoID tallerDeDisenoID) {
        super(tallerDeDisenoID);
        subscribe(new TallerDeDisenoEventChange(this));
    }

    public static TallerDeDiseno from(TallerDeDisenoID id, List<DomainEvent> events){ //reconstruccion de la granja teniendo id y eventos
        var tallerDeDiseno = new TallerDeDiseno(id);
        events.forEach(tallerDeDiseno::applyEvent);
        return tallerDeDiseno;
    } */
}

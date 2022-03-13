package domain.tallerdediseno;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.event.DisenadorAgregadado;
import domain.tallerdediseno.event.DisenoAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenadorID;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;
import domain.value.Persona;

import java.util.List;
import java.util.Map;

public class TallerDeDiseno extends AggregateEvent<TallerDeDisenoID> {

    protected Map<String, Diseno> diseños;
    protected Map<String, Disenador> diseñadores;
    protected List<Boceto> bocetos;

    public TallerDeDiseno(TallerDeDisenoID entityId) {
        super(entityId);
        appendChange(new TallerDeDisenoCreado(entityId)).apply();
        subscribe(new TallerDeDisenoEventChange(this)); //Para realizar un cambio en el estado debo suscribirla
    }



    private TallerDeDiseno(TallerDeDisenoID tallerDeDisenoID,String use) {
        super(tallerDeDisenoID);
        subscribe(new TallerDeDisenoEventChange(this));
    }

    public static TallerDeDiseno from(TallerDeDisenoID id, List<DomainEvent> events){ //reconstruccion de la granja teniendo id y eventos
        var tallerDeDiseno = new TallerDeDiseno(id,"as");
        events.forEach(tallerDeDiseno::applyEvent);
        return tallerDeDiseno;
    }

    public void agregarDiseñador(DisenadorID disenadorID, Persona persona, int numeroDeProyectosEnSimultaneo){
        appendChange(new DisenadorAgregadado(disenadorID,persona,numeroDeProyectosEnSimultaneo)).apply();
    }

    public void agregarDiseno(DisenoID disenoID, Boceto boceto, String comentariosDeBoceto){
        appendChange(new DisenoAgregadado(disenoID,boceto,comentariosDeBoceto)).apply();
    }

}

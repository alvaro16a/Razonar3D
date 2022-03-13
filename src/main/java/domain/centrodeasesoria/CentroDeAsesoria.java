package domain.centrodeasesoria;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.tallerdediseno.Disenador;
import domain.tallerdediseno.Diseno;
import domain.tallerdediseno.TallerDeDisenoEventChange;
import domain.tallerdediseno.event.DisenadorAgregadado;
import domain.tallerdediseno.event.DisenoAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenadorID;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;
import domain.value.Idea;
import domain.value.Persona;

import java.util.List;
import java.util.Map;

public class CentroDeAsesoria extends AggregateEvent<CentroDeAsesoriaID> {

    protected Map<String, Asesoria> asesorias;
    protected Map<String, Ingeniero> ingenieros;
    protected List<Idea> ideas;

    public CentroDeAsesoria(CentroDeAsesoriaID entityId) {
        super(entityId);
        appendChange(new CentroDeAsesoriaCreado(entityId)).apply();
        subscribe(new CentroDeAsesoriaEventChange(this)); //Para realizar un cambio en el estado debo suscribirla

    }

   /* public CentroDeAsoria(TallerDeDisenoID entityId) {
        super(entityId);
        appendChange(new TallerDeDisenoCreado(entityId)).apply();
        subscribe(new TallerDeDisenoEventChange(this)); //Para realizar un cambio en el estado debo suscribirla
    }*/


}

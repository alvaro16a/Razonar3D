package domain.cliente;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.event.ClienteJuridicoCreado;
import domain.cliente.event.ClienteNaturalCreado;
import domain.cliente.event.TrabajoCreado;
import domain.cliente.value.*;
import domain.granja.GranjaEventChange;
import domain.value.Idea;
import domain.value.Persona;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteID> {

    protected Trabajo trabajo;
    protected Empresa empresa;
    protected Persona persona;
    protected InformacionDeContacto contacto;

    public Cliente(ClienteID entityId, Empresa empresa, InformacionDeContacto contacto) {
        super(entityId);
        this.empresa = empresa;
        this.contacto = contacto;
        appendChange(new ClienteJuridicoCreado(empresa, contacto)).apply();
        subscribe(new ClienteEventChange(this));
    }

    public Cliente(ClienteID entityId, Persona persona, InformacionDeContacto contacto) {
        super(entityId);
        this.persona = persona;
        this.contacto = contacto;
        appendChange(new ClienteNaturalCreado(persona, contacto)).apply();
        subscribe(new ClienteEventChange(this));
    }

    private Cliente(ClienteID clienteID){
        super(clienteID);
        subscribe(new ClienteEventChange(this));
    }

    public  static Cliente from(ClienteID id, List<DomainEvent> events){
        var cliente = new Cliente(id);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void crearTrabajo(TrabajoID trabajoID, Idea idea, Tipo tipo){
        appendChange(new TrabajoCreado(trabajoID, idea, tipo)).apply();
    }

}

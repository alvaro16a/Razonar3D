package domain.cliente;


import co.com.sofka.domain.generic.AggregateEvent;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;
import domain.value.Persona;

public class Cliente extends AggregateEvent<ClienteID> {

    protected Trabajo trabajo;
    protected Empresa empresa;
    protected Persona persona;
    protected InformacionDeContacto contacto;

    public Cliente(ClienteID entityId, Empresa empresa, InformacionDeContacto contacto) {
        super(entityId);
        this.empresa = empresa;
        this.contacto = contacto;
    }

    public Cliente(ClienteID entityId, Persona persona, InformacionDeContacto contacto) {
        super(entityId);
        this.persona = persona;
        this.contacto = contacto;
    }

}
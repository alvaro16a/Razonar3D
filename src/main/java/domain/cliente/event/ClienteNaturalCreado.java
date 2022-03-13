package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.value.InformacionDeContacto;
import domain.value.Persona;

public class ClienteNaturalCreado extends DomainEvent {

    private final Persona persona;
    private final InformacionDeContacto contacto;

    public ClienteNaturalCreado(Persona persona, InformacionDeContacto contacto) {
        super("cliente.clientenaturalcreado");
        this.persona = persona;
        this.contacto = contacto;
    }

    public Persona getPersona() {
        return persona;
    }

    public InformacionDeContacto getContacto() {
        return contacto;
    }
}

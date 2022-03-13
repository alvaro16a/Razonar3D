package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;
import domain.value.Persona;

import java.util.Objects;

public class CrearClienteNatural extends Command {

    private final ClienteID clienteID;
    private final Persona persona;
    private final InformacionDeContacto contacto;

    public CrearClienteNatural(ClienteID clienteID, Persona persona, InformacionDeContacto contacto) {
        this.clienteID = clienteID;
        this.persona = Objects.requireNonNull(persona);
        this.contacto = Objects.requireNonNull(contacto);
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Persona getPersona() {
        return persona;
    }

    public InformacionDeContacto getContacto() {
        return contacto;
    }
}

package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;

import java.util.Objects;

public class CrearClienteJuridico extends Command {

    private final ClienteID clienteID;
    private final Empresa empresa;
    private final InformacionDeContacto contacto;

    public CrearClienteJuridico(ClienteID entityId, Empresa empresa, InformacionDeContacto contacto) {
        this.clienteID = entityId;
        this.empresa = Objects.requireNonNull(empresa);
        this.contacto = Objects.requireNonNull(contacto);
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public InformacionDeContacto getContacto() {
        return contacto;
    }
}

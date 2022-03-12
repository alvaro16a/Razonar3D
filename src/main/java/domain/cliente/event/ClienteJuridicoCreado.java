package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.value.Empresa;
import domain.cliente.value.InformacionDeContacto;

public class ClienteJuridicoCreado extends DomainEvent {
    private final Empresa empresa;
    private final InformacionDeContacto contacto;

    public ClienteJuridicoCreado(Empresa empresa, InformacionDeContacto contacto) {
        super("cliente.clientejuridicocreado");
        this.empresa=empresa;
        this.contacto=contacto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public InformacionDeContacto getContacto() {
        return contacto;
    }
}

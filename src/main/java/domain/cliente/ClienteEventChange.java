package domain.cliente;

import co.com.sofka.domain.generic.EventChange;
import domain.cliente.event.ClienteJuridicoCreado;

public class ClienteEventChange extends EventChange {
    public ClienteEventChange(Cliente cliente) {

        apply((ClienteJuridicoCreado event) ->{

            cliente.contacto = event.getContacto();
            cliente.empresa = event.getEmpresa();
            cliente.contacto= event.getContacto();

        });

    }
}

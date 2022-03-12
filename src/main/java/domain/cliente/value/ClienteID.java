package domain.cliente.value;

import co.com.sofka.domain.generic.Identity;

public class ClienteID extends Identity {

    private ClienteID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public ClienteID(){} //Este permite que se cree el elemento
    public static ClienteID of(String valor) {
        return new ClienteID(valor);
    }

}

package domain.cliente.value;

import co.com.sofka.domain.generic.Identity;

public class TrabajoID extends Identity {

    private TrabajoID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public TrabajoID(){} //Este permite que se cree el elemento
    public static TrabajoID of(String valor) {
        return new TrabajoID(valor);
    }

}

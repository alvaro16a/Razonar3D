package domain.tallerdediseno.command.granja.value;

import co.com.sofka.domain.generic.Identity;

public class ImpresoraID extends Identity {

    private ImpresoraID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public ImpresoraID(){} //Este permite que se cree el elemento
    public static ImpresoraID of(String valor) {
        return new ImpresoraID(valor);
    }

}

package domain.tallerdediseno.command.granja.value;

import co.com.sofka.domain.generic.Identity;

public class GranjaID extends Identity {

    private GranjaID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public GranjaID(){} //Este permite que se cree el elemento
    public static GranjaID of(String valor) {
        return new GranjaID(valor);
    }

}

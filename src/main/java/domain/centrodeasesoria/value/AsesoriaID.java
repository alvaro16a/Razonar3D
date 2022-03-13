package domain.tallerdediseno.value;

import co.com.sofka.domain.generic.Identity;

public class DisenadorID extends Identity {

    private DisenadorID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public DisenadorID(){} //Este permite que se cree el elemento
    public static DisenadorID of(String valor) {
        return new DisenadorID(valor);
    }

}

package domain.centrodeasesoria.value;

import co.com.sofka.domain.generic.Identity;

public class IngenieroID extends Identity {

    private IngenieroID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public IngenieroID(){} //Este permite que se cree el elemento
    public static IngenieroID of(String valor) {
        return new IngenieroID(valor);
    }

}

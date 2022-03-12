package domain.granja.value;

import co.com.sofka.domain.generic.Identity;

public class EncargadoID extends Identity {

    private EncargadoID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public EncargadoID(){} //Este permite que se cree el elemento
    public static EncargadoID of(String valor) {
        return new EncargadoID(valor);
    }

}

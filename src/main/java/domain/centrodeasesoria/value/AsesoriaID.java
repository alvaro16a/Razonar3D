package domain.centrodeasesoria.value;

import co.com.sofka.domain.generic.Identity;

public class AsesoriaID extends Identity {

    private AsesoriaID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public AsesoriaID(){} //Este permite que se cree el elemento
    public static AsesoriaID of(String valor) {
        return new AsesoriaID(valor);
    }

}

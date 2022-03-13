package domain.centrodeasesoria.value;

import co.com.sofka.domain.generic.Identity;

public class CentroDeAsesoriaID extends Identity {

    private CentroDeAsesoriaID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public CentroDeAsesoriaID(){} //Este permite que se cree el elemento
    public static CentroDeAsesoriaID of(String valor) {
        return new CentroDeAsesoriaID(valor);
    }

}

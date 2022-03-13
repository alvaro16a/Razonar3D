package domain.tallerdediseno.value;

import co.com.sofka.domain.generic.Identity;

public class DisenoID extends Identity {

    private DisenoID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public DisenoID(){} //Este permite que se cree el elemento
    public static DisenoID of(String valor) {
        return new DisenoID(valor);
    }

}

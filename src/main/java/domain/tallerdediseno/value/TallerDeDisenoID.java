package domain.tallerdediseno.value;

import co.com.sofka.domain.generic.Identity;

public class TallerDeDisenoID extends Identity {

    private TallerDeDisenoID(String valor){ //este constructor privado le asigna el valor al id
        super(valor);
    }

    public TallerDeDisenoID(){} //Este permite que se cree el elemento
    public static TallerDeDisenoID of(String valor) {
        return new TallerDeDisenoID(valor);
    }

}

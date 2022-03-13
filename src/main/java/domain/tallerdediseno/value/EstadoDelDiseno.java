package domain.tallerdediseno.value;

import co.com.sofka.domain.generic.ValueObject;

public class EstadoDelDiseno implements ValueObject<EstadoDelDiseno.Estado> {

    private final Estado value;

    public EstadoDelDiseno(Estado value){
        this.value =value;
    }
    public EstadoDelDiseno(){
        this.value = Estado.ESPERA;
    }

    @Override
    public Estado value(){
        return value;
    }

    public enum Estado {
        INICIADO, TERMINADO, ESPERA, SUSPENDIDO
    }
}

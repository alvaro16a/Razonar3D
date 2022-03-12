package domain.cliente.value;

import co.com.sofka.domain.generic.ValueObject;

public class Fase implements ValueObject<Fase.Etapa> {
    private final Etapa value;

    public Fase() {
        this.value= Etapa.FABRICACION;
    }

    public Fase(Etapa value) {
        this.value = value;
    }

    @Override
    public Etapa value(){
        return value;
    }

    public enum Etapa{
        CONSULTORIA,DISEÑO,FABRICACION,TALLER
    }
}

package domain.tallerdediseno.command.granja.value;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Estado.Operacional> {

    private final Operacional value;

    public Estado(Operacional value){
        this.value =value;
    }
    public Estado(){
        this.value =Operacional.APAGADA;
    }

    @Override
    public Operacional value(){
        return value;
    }

    public enum Operacional{
        IMPRIMIENDO, APAGADA, MANTENIMIENTO, AVERIADO
    }
}

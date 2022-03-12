package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Dificultad implements ValueObject<Dificultad.Nivel> {

    private final Nivel value;

    public Dificultad() {
        this.value = Nivel.MEDIO;
    }

    public Dificultad(Nivel value) {
        this.value = value;
    }

    @Override
    public Nivel value(){
        return value;
    }

    public enum Nivel{
        FACIL,MEDIO,DIFICIL,EXTREMO
    }
}

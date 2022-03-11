package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Color implements ValueObject<Color.Paleta> {
    private final Paleta value;

    public Color() {
        this.value= Paleta.NEGRO;
    }

    public Color(Paleta value) {
        this.value = value;
    }

    @Override
    public Paleta value(){
        return value;
    }

    public enum Paleta{
        ROJO,VERDE,NEGRO,GRIS,AMARILLO,BLANCO,AZUL,NARANJA
    }
}

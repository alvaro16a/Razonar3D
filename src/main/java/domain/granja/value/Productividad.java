package domain.granja.value;

import co.com.sofka.domain.generic.ValueObject;

public class Productividad implements ValueObject<Productividad.Nivel> {

    private final Nivel value;

    public Productividad() {
        this.value = Nivel.MEDIA;
    }

    public Productividad(Nivel value) {
        this.value = value;
    }

    @Override
    public Nivel value(){
        return value;
    }

    public enum Nivel{
        BAJA,MEDIA,ALTA,SUPERIOR
    }
}

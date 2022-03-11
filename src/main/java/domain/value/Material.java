package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Material implements ValueObject<Material.Nombre> {
    private final Nombre value;

    public Material() {
        this.value=Nombre.PLA;
    }

    public Material(Nombre value) {
        this.value = value;
    }

    @Override
    public Nombre value(){
        return value;
    }
    
    public enum Nombre{
        PLA, ABS, PETG, NYLON
    }
}

package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Material implements ValueObject<Material.Filamento> {
    private final Filamento value;

    public Material() {
        this.value=Filamento.PLA;
    }

    public Material(Filamento value) {
        this.value = value;
    }

    @Override
    public Filamento value(){
        return value;
    }

    public enum Filamento{
        PLA, ABS, PETG, NYLON
    }
}

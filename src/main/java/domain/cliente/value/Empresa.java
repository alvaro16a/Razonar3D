package domain.cliente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Empresa implements ValueObject<Empresa.Props> {

    private final String nombre;
    private final String  rut;

    public Empresa(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return null;
            }

            @Override
            public String rut() {
                return null;
            }
        };
    }

    public interface Props{
        String nombre();
        String rut();
    }

}

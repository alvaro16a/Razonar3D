package domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Persona implements ValueObject<Persona.Props> {

    private final String nombre;
    private final String apellido;
    private final String  documento;

    public Persona(String nombre, String apellido, String documento) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.documento = Objects.requireNonNull(documento);
    }

    public Persona() {
        this.nombre = "Name";
        this.apellido = "LastName";
        this.documento = "document";
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String apellido() {
                return apellido;
            }

            @Override
            public String documento() {
                return documento;
            }
        };
    }

    public interface Props{
        String nombre();
        String apellido();
        String documento();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

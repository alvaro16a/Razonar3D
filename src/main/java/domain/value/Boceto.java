package domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Boceto implements ValueObject<Boceto.Props> {

    private final String nombre;
    private final String detalles;
    private  final Dimensiones esquema;


    public Boceto(String nombre, String detalles, Dimensiones esquema) {
        this.nombre =Objects.requireNonNull(nombre) ;
        this.detalles =Objects.requireNonNull(detalles);
        this.esquema = Objects.requireNonNull(esquema);
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String detalles() {
                return detalles;
            }

            @Override
            public Dimensiones esquema() {
                return esquema;
            }
        };
    }

    public interface Props{
        String nombre();
        String detalles();
        Dimensiones esquema();
    }
}

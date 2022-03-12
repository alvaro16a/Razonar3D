package domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Idea implements ValueObject<Idea.Props> {

    private final String nombre;
    private final String pensamiento;
    private  final Dimensiones borrador;


    public Idea(String nombre, Dimensiones borrador,String pensamiento) {
        this.nombre =Objects.requireNonNull(nombre) ;
        this.borrador = borrador; //no se valida porque para iniciar un pensamiento basta
        this.pensamiento = Objects.requireNonNull(pensamiento);
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Dimensiones borrador() {
                return borrador;
            }

            @Override
            public String pensamiento() {
                return pensamiento;
            }
        };
    }

    public interface Props{
        String nombre();
        Dimensiones borrador();
        String pensamiento();
    }
}

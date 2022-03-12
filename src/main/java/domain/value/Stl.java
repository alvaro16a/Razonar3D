package domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Stl implements ValueObject<Stl.Props> {

    private final String nombre;
    private final Integer tiempoDeImpresion;
    private final Dificultad dificultad;

    public Stl(String nombre, Integer tiempoDeImpresion) {
        this.nombre = Objects.requireNonNull(nombre);
        if(tiempoDeImpresion <= 0){
            throw new RuntimeException("el tiempo de impresion debe ser positivo");
        }else{
            this.tiempoDeImpresion = tiempoDeImpresion;
            this.dificultad = new Dificultad();
        }
    }

    public Stl(String nombre, Integer tiempoDeImpresion, Dificultad dificultad) {
        this.nombre = Objects.requireNonNull(nombre);
        if(tiempoDeImpresion <= 0){
            throw new RuntimeException("el tiempo de impresion debe ser positivo");
        }else{
            this.tiempoDeImpresion = tiempoDeImpresion;
            this.dificultad = dificultad;
        }

    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Integer tiempoDeImpresion() {
                return tiempoDeImpresion;
            }

            @Override
            public Dificultad dificultad() {
                return dificultad;
            }
        };
    }

    public interface Props{
        String nombre();
        Integer tiempoDeImpresion();
        Dificultad dificultad();
    }
}

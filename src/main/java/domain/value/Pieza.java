package domain.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Pieza implements ValueObject<Pieza.Props> {

    private final String nombre;
    private final Material material;
    private final Dimensiones dimensiones;
    private final Color color;

    public Pieza(String nombre, Material material) {
        this.nombre = Objects.requireNonNull(nombre);
        this.material = Objects.requireNonNull(material);
        this.color = new Color();
        this.dimensiones =new Dimensiones();
    }

    public Pieza(String nombre, Material material, Dimensiones dimensiones, Color color) {
        this.nombre = Objects.requireNonNull(nombre);
        this.material = Objects.requireNonNull(material);
        this.dimensiones = Objects.requireNonNull(dimensiones);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Material material() {
                return material;
            }

            @Override
            public Dimensiones dimensiones() {
                return dimensiones;
            }

            @Override
            public Color color() {
                return color;
            }
        };
    }

    public interface Props{

        String nombre();
        Material material();
        Dimensiones dimensiones();
        Color color();
    }

}

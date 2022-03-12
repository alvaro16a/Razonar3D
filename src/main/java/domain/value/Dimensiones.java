package domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Dimensiones implements ValueObject<Dimensiones.Props> {

    private final Integer alto;
    private final Integer largo;
    private final Integer  ancho;


    public Dimensiones(Integer alto, Integer largo, Integer ancho) {
        if(alto <= 0 || largo <=0 || ancho <= 0){
            throw new RuntimeException("Todas las dimensiones deben ser positivas");
        }else{
            this.alto = alto;
            this.largo = largo;
            this.ancho = ancho;
        }
    }

    public Dimensiones() {
        this.alto = 15;
        this.largo = 15;
        this.ancho = 10;
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public int alto() {
                return alto;
            }

            @Override
            public int largo() {
                return largo;
            }

            @Override
            public int ancho() {
                return ancho;
            }
        };
    }


    public interface Props{
        int alto();
        int largo();
        int ancho();
    }

}

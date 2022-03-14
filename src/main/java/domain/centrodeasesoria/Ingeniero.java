package domain.centrodeasesoria;

import co.com.sofka.domain.generic.Entity;
import domain.centrodeasesoria.value.IngenieroID;
import domain.granja.value.Productividad;
import domain.tallerdediseno.value.DisenadorID;
import domain.value.Persona;

import java.util.Objects;

public class Ingeniero extends Entity<IngenieroID> {

    private Persona persona;
    private Productividad productividadLaboral;
    private int numeroDeAsesoriasEnSimultaneo;

    public Ingeniero(IngenieroID ingenieroID, Persona persona, int numeroDeAsesoriasEnSimultaneo) {
        super(ingenieroID);
        this.persona = persona;
        if(numeroDeAsesoriasEnSimultaneo <= 0){
            throw new RuntimeException("Un diseñador debe tener la capacidad de diseñar algo");
        }else if(numeroDeAsesoriasEnSimultaneo <= 1){
            this.numeroDeAsesoriasEnSimultaneo = numeroDeAsesoriasEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.BAJA);
        }else if(numeroDeAsesoriasEnSimultaneo <= 3){
            this.numeroDeAsesoriasEnSimultaneo = numeroDeAsesoriasEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.MEDIA);
        }else if(numeroDeAsesoriasEnSimultaneo <= 5){
            this.numeroDeAsesoriasEnSimultaneo = numeroDeAsesoriasEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.ALTA);
        }else{
            this.numeroDeAsesoriasEnSimultaneo = numeroDeAsesoriasEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.SUPERIOR);
        }
    }

    public void modificarDatosPersonales(Persona persona){

        this.persona= Objects.requireNonNull(persona);
    }

    public void modificarproductividadLaboral(Productividad productividad){
        this.productividadLaboral= Objects.requireNonNull(productividad);
    }

    public void cambiarAsesoriasEnSimultaneo(int numeroDeAsesoriasEnSimultaneo) {
        if(numeroDeAsesoriasEnSimultaneo <= 0){
            throw new RuntimeException("debe ser positivo");
        }else{
            this.numeroDeAsesoriasEnSimultaneo = numeroDeAsesoriasEnSimultaneo;
        }
    }

    public Persona obtenerDatosPersonales() {
        return persona;
    }

    public Productividad obtenerProductividadLaboral() {
        return productividadLaboral;
    }

    public int capacidadDeProyectosEnSimultaneo() {
        return numeroDeAsesoriasEnSimultaneo;
    }
}

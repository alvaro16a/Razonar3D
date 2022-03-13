package domain.tallerdediseno;

import co.com.sofka.domain.generic.Entity;
import domain.granja.value.EncargadoID;
import domain.granja.value.Productividad;
import domain.value.Persona;

import java.util.Objects;

public class Disenador extends Entity<EncargadoID> {

    private Persona persona;
    private Productividad productividadLaboral;
    private int numeroDeProyectosEnSimultaneo;

    public Disenador(EncargadoID entityId, Persona persona) {
        super(entityId);
        this.persona = persona;
        if(numeroDeProyectosEnSimultaneo <= 0){
            throw new RuntimeException("Un diseñador debe tener la capacidad de diseñar algo");
        }else if(numeroDeProyectosEnSimultaneo <= 1){
            this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.BAJA);
        }else if(numeroDeProyectosEnSimultaneo <= 3){
            this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.MEDIA);
        }else if(numeroDeProyectosEnSimultaneo <= 5){
            this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.ALTA);
        }else{
            this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
            this.productividadLaboral=new Productividad(Productividad.Nivel.SUPERIOR);
        }
    }

    public void modificarDatosPersonales(Persona persona){

        this.persona= Objects.requireNonNull(persona);
    }

    public void modificarproductividadLaboral(Productividad productividad){

        this.productividadLaboral= Objects.requireNonNull(productividad);
    }

    public void cambiarProyectosEnSimultaneo(int numeroDeProyectosEnSimultaneo) {
        if(numeroDeProyectosEnSimultaneo <= 0){
            throw new RuntimeException("debe ser positivo");
        }else{
            this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
        }
    }

    public Persona obtenerDatosPersonales() {
        return persona;
    }

    public Productividad obtenerProductividadLaboral() {
        return productividadLaboral;
    }

    public int capacidadDeProyectosEnSimultaneo() {
        return numeroDeProyectosEnSimultaneo;
    }
}

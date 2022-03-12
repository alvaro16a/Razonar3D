package domain.granja;

import co.com.sofka.domain.generic.Entity;
import domain.granja.value.EncargadoID;
import domain.granja.value.Productividad;
import domain.value.Persona;

public class Encargado extends Entity<EncargadoID> {

    private Persona persona;
    private Productividad productividadLaboral;
    private int capacidadDeAdministrarImpresoras;

    public Encargado(EncargadoID entityId, Persona persona, int capacidadDeAdministrarImpresoras) {
        super(entityId);
        this.persona = persona;
        if(capacidadDeAdministrarImpresoras <= 0){
            throw new RuntimeException("El encargado de la granja debe conocer algo de impresoras 3D");
        }else if(capacidadDeAdministrarImpresoras <= 15){
            this.capacidadDeAdministrarImpresoras = capacidadDeAdministrarImpresoras;
            this.productividadLaboral=new Productividad(Productividad.Nivel.BAJA);
        }else if(capacidadDeAdministrarImpresoras <= 30){
            this.capacidadDeAdministrarImpresoras = capacidadDeAdministrarImpresoras;
            this.productividadLaboral=new Productividad(Productividad.Nivel.MEDIA);
        }else if(capacidadDeAdministrarImpresoras <= 40){
            this.capacidadDeAdministrarImpresoras = capacidadDeAdministrarImpresoras;
            this.productividadLaboral=new Productividad(Productividad.Nivel.ALTA);
        }else{
            this.capacidadDeAdministrarImpresoras = capacidadDeAdministrarImpresoras;
            this.productividadLaboral=new Productividad(Productividad.Nivel.SUPERIOR);
        }
    }

    public void modificarDatosPersonales(Persona persona){
        this.persona=persona;
    }

    public Productividad obtenerProductividadLaboral() {
        return productividadLaboral;
    }

    public void cambiarCapacidadDeAdministrarImpresoras(int capacidadDeAdministrarImpresoras) {
        if(capacidadDeAdministrarImpresoras <= 0){
            throw new RuntimeException("debe ser positivo");
        }else{
            this.capacidadDeAdministrarImpresoras = capacidadDeAdministrarImpresoras;
        }
    }
}

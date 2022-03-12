package domain.granja;

import co.com.sofka.domain.generic.EventChange;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresionIncluida;
import domain.granja.event.ImpresionIniciada;
import domain.granja.event.ImpresoraIncluida;
import domain.value.Stl;

import java.util.ArrayList;
import java.util.HashMap;

public class GranjaEventChange extends EventChange {
    public GranjaEventChange(Granja granja) {

        apply((GranjaCreada event) -> {

            granja.encargado = event.getEncargado();
            granja.impresoras = new HashMap<>();
            granja.stls = new ArrayList<>();

        });

        apply((ImpresoraIncluida event) ->{
            if(granja.impresoras.size()< granja.encargado.getCapacidadDeAdministrarImpresoras()) {
                granja.impresoras.put(event.getImpresoraID().value(),//convierto el Id en la llave
                        new Impresora3D(event.getImpresoraID()));
            }else{
                throw new RuntimeException("El encargado no puede manejar mas impresoras de las que tiene asignadas");
            }
        });

        apply((ImpresionIncluida event) ->{
            granja.stls.add(event.getStl());
        });

        apply((ImpresionIniciada event) -> {
            Impresora3D impresora3D=granja.impresoras.get(event.getImpresoraID());//uso el id como llave para obtener la impresora
            Stl stl=granja.stls.get(0); //obtengo el proximo stl en la lista de espera
            impresora3D.iniciarImpresion(stl);
            granja.stls.remove(0); //remuevo el stl de la lista de pendientes

        });
    }
}

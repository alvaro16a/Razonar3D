package domain.tallerdediseno;

import co.com.sofka.domain.generic.EventChange;
import domain.tallerdediseno.event.DiseñadorAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;
import domain.tallerdediseno.value.DisenadorID;
import domain.value.Persona;

import java.util.ArrayList;
import java.util.HashMap;

public class TallerDeDisenoEventChange extends EventChange {
    public TallerDeDisenoEventChange(TallerDeDiseno tallerDeDiseno) {

        apply((TallerDeDisenoCreado event) -> {
            tallerDeDiseno.diseños = new HashMap<>();
            tallerDeDiseno.diseñadores = new HashMap<>();
            tallerDeDiseno.bocetos = new ArrayList<>();
        });

        apply((DiseñadorAgregadado event) -> {
            tallerDeDiseno.diseñadores.put(event.getDisenadorID().value(),new Disenador(event.getDisenadorID(),event.getPersona(),event.getNumeroDeProyectosEnSimultaneo()));
        });
    }
}

package domain.tallerdediseno;

import co.com.sofka.domain.generic.EventChange;
import domain.tallerdediseno.event.DisenadorAgregadado;
import domain.tallerdediseno.event.DisenoAgregadado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;

import java.util.ArrayList;
import java.util.HashMap;

public class TallerDeDisenoEventChange extends EventChange {
    public TallerDeDisenoEventChange(TallerDeDiseno tallerDeDiseno) {

        apply((TallerDeDisenoCreado event) -> {
            tallerDeDiseno.diseños = new HashMap<>();
            tallerDeDiseno.diseñadores = new HashMap<>();
            tallerDeDiseno.bocetos = new ArrayList<>();
        });

        apply((DisenadorAgregadado event) -> {
            tallerDeDiseno.diseñadores.put(event.getDisenadorID().value(),new Disenador(event.getDisenadorID(),event.getPersona(),event.getNumeroDeProyectosEnSimultaneo()));
        });

        apply((DisenoAgregadado event) -> {
            tallerDeDiseno.diseños.put(event.getDicenoID().value(),new Diseno(event.getDicenoID(),event.getBoceto(), event.getComentariosDeBoceto()));
        });
    }
}

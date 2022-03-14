package domain.centrodeasesoria;

import co.com.sofka.domain.generic.EventChange;
import domain.centrodeasesoria.event.AsesoriaAgregada;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.centrodeasesoria.event.IngenieroAgregado;

import java.util.ArrayList;
import java.util.HashMap;

public class CentroDeAsesoriaEventChange extends EventChange {
    public CentroDeAsesoriaEventChange(CentroDeAsesoria centroDeAsesoria) {

        apply((CentroDeAsesoriaCreado event) -> {
            centroDeAsesoria.asesorias = new HashMap<>();
            centroDeAsesoria.ingenieros = new HashMap<>();
            centroDeAsesoria.ideas = new ArrayList<>();
        });

        apply((IngenieroAgregado event) -> {
            centroDeAsesoria.ingenieros.put(event.getIngenieroID().value(),new Ingeniero(event.getIngenieroID(),event.getPersona(),event.getNumeroDeAsesoriasEnSimultaneo()));
        });

        apply((AsesoriaAgregada event) -> {
            centroDeAsesoria.asesorias.put(event.getAsesoriaId().value(),new Asesoria(event.getAsesoriaId(),event.getIdea(),event.getEspectativasIdea()));
        });
    }
}

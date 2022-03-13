package domain.centrodeasesoria;

import co.com.sofka.domain.generic.EventChange;
import domain.centrodeasesoria.event.CentroDeAsesoriaCreado;
import domain.tallerdediseno.event.TallerDeDisenoCreado;

import java.util.ArrayList;
import java.util.HashMap;

public class CentroDeAsesoriaEventChange extends EventChange {
    public CentroDeAsesoriaEventChange(CentroDeAsesoria centroDeAsesoria) {

        apply((CentroDeAsesoriaCreado event) -> {
            centroDeAsesoria.asesorias = new HashMap<>();
            centroDeAsesoria.ingenieros = new HashMap<>();
            centroDeAsesoria.ideas = new ArrayList<>();
        });
    }
}

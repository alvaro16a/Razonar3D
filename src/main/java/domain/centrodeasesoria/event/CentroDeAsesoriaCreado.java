package domain.centrodeasesoria.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;

public class CentroDeAsesoriaCreado extends DomainEvent {

    private  final CentroDeAsesoriaID centroDeAsesoriaID;

    public CentroDeAsesoriaCreado(CentroDeAsesoriaID entityId) {
        super("centrodeasesoria.creado");
        this.centroDeAsesoriaID = entityId;
    }

    public CentroDeAsesoriaID getCentroDeAsesoriaID() {
        return centroDeAsesoriaID;
    }
}

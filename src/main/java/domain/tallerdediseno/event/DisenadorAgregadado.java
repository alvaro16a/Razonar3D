package domain.tallerdediseno.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.value.DisenadorID;
import domain.value.Persona;

public class DisenadorAgregadado extends DomainEvent {

    private final DisenadorID disenadorID;
    private final Persona persona;
    private final Integer numeroDeProyectosEnSimultaneo;

    public DisenadorAgregadado(DisenadorID disenadorID, Persona persona, int numeroDeProyectosEnSimultaneo) {
        super("tallerdediseno.disenadoragregado");
        this.disenadorID=disenadorID;
        this.persona = persona;
        this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
    }

    public DisenadorID getDisenadorID() {
        return disenadorID;
    }

    public Persona getPersona() {
        return persona;
    }

    public Integer getNumeroDeProyectosEnSimultaneo() {
        return numeroDeProyectosEnSimultaneo;
    }
}

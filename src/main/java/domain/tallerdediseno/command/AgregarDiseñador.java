package domain.tallerdediseno.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.value.DisenadorID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Persona;

public class AgregarDiseñador extends Command {

    private  final TallerDeDisenoID tallerDeDisenoID;
    private final DisenadorID disenadorID;
    private final Persona persona;
    private final int numeroDeProyectosEnSimultaneo;

    public AgregarDiseñador(TallerDeDisenoID tallerDeDisenoID,DisenadorID entityId, Persona persona, int numeroDeProyectosEnSimultaneo) {
        this.disenadorID = entityId;
        this.persona = persona;
        this.numeroDeProyectosEnSimultaneo = numeroDeProyectosEnSimultaneo;
        this.tallerDeDisenoID=tallerDeDisenoID;
    }

    public DisenadorID getDisenadorID() {return disenadorID;}
    public Persona getPersona() {return persona;}
    public int getNumeroDeProyectosEnSimultaneo() {return numeroDeProyectosEnSimultaneo;}
    public TallerDeDisenoID getTallerDeDisenoID() {
        return tallerDeDisenoID;
    }
}

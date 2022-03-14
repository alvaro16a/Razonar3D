package domain.centrodeasesoria.command;

import co.com.sofka.domain.generic.Command;
import domain.centrodeasesoria.value.CentroDeAsesoriaID;
import domain.centrodeasesoria.value.IngenieroID;
import domain.tallerdediseno.value.DisenadorID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Persona;

public class AgregarIngeniero extends Command {

    private  final CentroDeAsesoriaID centroDeAsesoriaID;
    private  final IngenieroID ingenieroID;
    private  final Persona persona;
    private  final int numeroDeAsesoriasEnSimultaneo;



    public AgregarIngeniero(CentroDeAsesoriaID centroDeAsesoriaID, IngenieroID ingenieroID, Persona persona, int numeroDeAsesoriasEnSimultaneo) {
        this.centroDeAsesoriaID=centroDeAsesoriaID;
        this.ingenieroID=ingenieroID;
        this.persona=persona;
        this.numeroDeAsesoriasEnSimultaneo=numeroDeAsesoriasEnSimultaneo;
    }

    public CentroDeAsesoriaID getCentroDeAsesoriaID() {
        return centroDeAsesoriaID;
    }

    public IngenieroID getIngenieroID() {
        return ingenieroID;
    }

    public Persona getPersona() {
        return persona;
    }

    public int getNumeroDeAsesoriasEnSimultaneo() {
        return numeroDeAsesoriasEnSimultaneo;
    }
}

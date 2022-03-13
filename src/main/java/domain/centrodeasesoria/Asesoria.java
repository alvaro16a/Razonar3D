package domain.centrodeasesoria;

import co.com.sofka.domain.generic.Entity;
import domain.centrodeasesoria.value.AsesoriaID;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.EstadoDelDiseno;
import domain.value.Boceto;
import domain.value.Idea;

public class Asesoria extends Entity<AsesoriaID> {

    private Idea Idea;
    private Boceto boceto;
    private Integer horasDeAsesoria;
    private String espectativasIdea;
    private EstadoDelDiseno estadoDeAsesoria;

    public Asesoria(AsesoriaID entityId, Idea idea, String espectativasIdea) {
        super(entityId);
        this.Idea = idea;
        this.espectativasIdea = espectativasIdea;
        this.estadoDeAsesoria = new EstadoDelDiseno();
    }

    public void iniciarDiseno(){
        if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.ESPERA || this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.ESPERA) {
            this.estadoDeAsesoria = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else{
            throw new IllegalArgumentException("la asesoria ya inicio o termino por lo que no se puede iniciar");
        }
    }

    public void terminarDiseno(){
        if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.INICIADO) {
            this.estadoDeAsesoria = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else{
            throw new IllegalArgumentException("No se puede terminar un proceso de asesoria en el que no se esta trabajando");
        }
    }

    public void ponerDisenoEnEspera(){
        if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.INICIADO) {
            this.estadoDeAsesoria = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.TERMINADO){
            throw new IllegalArgumentException("No se puede pausar una asesoria que ya termino");
        }else if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.ESPERA){
            throw new IllegalArgumentException("la asesoria ya esta en pausa");
        }else{
            throw new IllegalArgumentException("Esta asesoria ya se suspendio");
        }
    }

    public void suspenderDiseno(){
        if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.INICIADO || this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.ESPERA ) {
            this.estadoDeAsesoria = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else if(this.estadoDeAsesoria.value()== EstadoDelDiseno.Estado.TERMINADO){
            throw new IllegalArgumentException("La asesoria ya Finalizo");
        }else{
            throw new IllegalArgumentException("Esta asesoria ya se suspendio");
        }
    }

}

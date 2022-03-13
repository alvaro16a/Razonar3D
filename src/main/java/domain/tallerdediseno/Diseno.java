package domain.tallerdediseno;

import co.com.sofka.domain.generic.Entity;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.EstadoDelDiseno;
import domain.value.Boceto;
import domain.value.Stl;

public class Diseno extends Entity<DisenoID> {

    private Boceto boceto;
    private Stl stl;
    private Integer horasDeDiseño;
    private String ComentariosDeBoceto;
    private EstadoDelDiseno estadoDelDiseno;

    public Diseno(DisenoID entityId, Boceto boceto, String comentariosDeBoceto) {
        super(entityId);
        this.boceto = boceto;
        this.ComentariosDeBoceto = comentariosDeBoceto;
        this.estadoDelDiseno = new EstadoDelDiseno();
    }

    public void iniciarDiseno(){
        if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.ESPERA || this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.ESPERA) {
            this.estadoDelDiseno = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else{
            throw new IllegalArgumentException("El proyecto ya inicio o termino por lo que no se puede iniciar");
        }
    }

    public void terminarDiseno(){
        if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.INICIADO) {
            this.estadoDelDiseno = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else{
            throw new IllegalArgumentException("No se puede terminar un proyecto en el que no se esta trabajando");
        }
    }

    public void ponerDisenoEnEspera(){
        if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.INICIADO) {
            this.estadoDelDiseno = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.TERMINADO){
            throw new IllegalArgumentException("No se puede pausar un proyecto que ya termino");
        }else if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.ESPERA){
            throw new IllegalArgumentException("El proyecto ya esta en pausa");
        }else{
            throw new IllegalArgumentException("Este proyecto ya se suspendio");
        }
    }

    public void suspenderDiseno(){
        if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.INICIADO || this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.ESPERA ) {
            this.estadoDelDiseno = new EstadoDelDiseno(EstadoDelDiseno.Estado.INICIADO);
        }else if(this.estadoDelDiseno.value()== EstadoDelDiseno.Estado.TERMINADO){
            throw new IllegalArgumentException("El proyecto ya Finalizo");
        }else{
            throw new IllegalArgumentException("Este proyecto ya se suspendio");
        }
    }

}

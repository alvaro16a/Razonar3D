package domain.cliente;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.value.Fase;
import domain.cliente.value.Tipo;
import domain.cliente.value.TrabajoID;
import domain.value.Boceto;
import domain.value.Idea;
import domain.value.Pieza;
import domain.value.Stl;

public class Trabajo extends Entity<TrabajoID> {

    private Idea idea;
    private Boceto boceto;
    private Stl stl;
    private Pieza pieza;
    private Tipo tipo;

    public Trabajo(TrabajoID entityId, Idea idea, Tipo tipo) {
        super(entityId);
        this.tipo = tipo;
    }

    public void solicitarConsultoria(Idea idea, Fase faseFinal){
        this.idea=idea;
        Fase faseInicial=new Fase(Fase.Etapa.CONSULTORIA);
        this.tipo=new Tipo(faseInicial,faseFinal);
    }

    public void realizarDiseño(Boceto boceto, Fase faseFinal){
        this.boceto=boceto;
        if(faseFinal.value() == Fase.Etapa.CONSULTORIA){
            throw new RuntimeException("ya tiene el boceto realizado, no tiene sentido realizar consultoria");
        }else{
            Fase faseInicial= new Fase(Fase.Etapa.DISEÑO);
            this.tipo=new Tipo(faseInicial,faseFinal);
        }

    }

    public void FabricarPieza(Stl stl, Fase faseFinal){
        this.stl=stl;
        if((faseFinal.value() == Fase.Etapa.CONSULTORIA)||(faseFinal.value() == Fase.Etapa.DISEÑO)){
            throw new RuntimeException("ya tiene el archivo STL, no tiene sentido realizar consultoria o diseño");
        }else{
            Fase faseInicial= new Fase(Fase.Etapa.FABRICACION);
            this.tipo=new Tipo(faseInicial,faseFinal);
        }

    }

}

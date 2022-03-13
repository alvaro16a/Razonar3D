package domain.tallerdediseno.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tallerdediseno.value.DisenoID;
import domain.value.Boceto;

public class DisenoAgregadado extends DomainEvent {


    private final DisenoID dicenoID;
    private final Boceto boceto;
    private final String comentariosDeBoceto;

    public DisenoAgregadado(DisenoID disenoID,Boceto boceto, String comentariosDeBoceto){
        super("tallerdediseno.disenoagregado");
        this.dicenoID=disenoID;
        this.boceto=boceto;
        this.comentariosDeBoceto=comentariosDeBoceto;
    }

    public DisenoID getDicenoID() {
        return dicenoID;
    }

    public Boceto getBoceto() {
        return boceto;
    }

    public String getComentariosDeBoceto() {
        return comentariosDeBoceto;
    }
}

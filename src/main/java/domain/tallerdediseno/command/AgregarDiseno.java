package domain.tallerdediseno.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.value.DisenoID;
import domain.tallerdediseno.value.TallerDeDisenoID;
import domain.value.Boceto;

public class AgregarDiseno extends Command {

    private  final TallerDeDisenoID tallerDeDisenoID;
    private  final DisenoID disenoID;
    private  final Boceto boceto;
    private  final String comentariosDeBoceto;

    public AgregarDiseno(TallerDeDisenoID tallerDeDisenoID, DisenoID entityId, Boceto boceto, String comentariosDeBoceto) {
        this.tallerDeDisenoID = tallerDeDisenoID;
        this.disenoID = entityId;
        this.boceto = boceto;
        this.comentariosDeBoceto = comentariosDeBoceto;
    }

    public TallerDeDisenoID getTallerDeDisenoID() {
        return tallerDeDisenoID;
    }

    public DisenoID getDisenoID() {
        return disenoID;
    }

    public Boceto getBoceto() {
        return boceto;
    }

    public String getComentariosDeBoceto() {
        return comentariosDeBoceto;
    }
}

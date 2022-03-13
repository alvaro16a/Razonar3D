package domain.tallerdediseno.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.Disenador;
import domain.tallerdediseno.value.TallerDeDisenoID;

public class CrearTallerDeDiseno extends Command {

    private final TallerDeDisenoID tallerDeDisenoID;
    private final Disenador disenador;

    public CrearTallerDeDiseno(TallerDeDisenoID tallerDeDisenoID, Disenador disenador) {
        this.tallerDeDisenoID = tallerDeDisenoID;
        this.disenador = disenador;
    }

    public TallerDeDisenoID getTallerDeDisenoID() {
        return tallerDeDisenoID;
    }

    public Disenador getDisenador() {
        return disenador;
    }
}

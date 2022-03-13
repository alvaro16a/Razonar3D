package domain.tallerdediseno.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.Disenador;
import domain.tallerdediseno.value.TallerDeDisenoID;

public class CrearTallerDeDiseno extends Command {

    private final TallerDeDisenoID tallerDeDisenoID;


    public CrearTallerDeDiseno(TallerDeDisenoID tallerDeDisenoID) {
        this.tallerDeDisenoID = tallerDeDisenoID;
    }

    public TallerDeDisenoID getTallerDeDisenoID() {
        return tallerDeDisenoID;
    }

}

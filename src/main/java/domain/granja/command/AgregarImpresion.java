package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;
import domain.value.Stl;

public class AgregarImpresion extends Command {

    private final GranjaID granjaID;
    private final Stl stl;

    public AgregarImpresion( GranjaID granjaID, Stl stl) {
        this.granjaID = granjaID;
        this.stl = stl;
    }

    public Stl getStl() {
        return stl;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

}

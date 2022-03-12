package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.Encargado;
import domain.granja.value.GranjaID;

public class CrearGranja extends Command {

    private final GranjaID granjaID;
    private final Encargado encargado;

    public CrearGranja(GranjaID granjaID,Encargado encargado) {
        this.granjaID = granjaID;
        this.encargado=encargado;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public Encargado getEncargado() {
        return encargado;
    }
}

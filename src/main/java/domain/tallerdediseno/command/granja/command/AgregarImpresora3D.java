package domain.tallerdediseno.command.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.command.granja.value.GranjaID;
import domain.tallerdediseno.command.granja.value.ImpresoraID;

public class AgregarImpresora3D extends Command {

    private final GranjaID granjaID;
    private final ImpresoraID impresoraID;

    public AgregarImpresora3D(GranjaID granjaID, ImpresoraID entityId) {
        this.granjaID = granjaID;
        this.impresoraID = entityId;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public ImpresoraID getImpresoraID() {
        return impresoraID;
    }

}

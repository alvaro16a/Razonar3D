package domain.tallerdediseno.command.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.tallerdediseno.command.granja.value.GranjaID;
import domain.tallerdediseno.command.granja.value.ImpresoraID;

public class IniciarImpresion extends Command {

    private final GranjaID granjaID;
    private final ImpresoraID impresoraID;

    public IniciarImpresion(GranjaID granjaID, ImpresoraID impresoraID) {
        this.granjaID = granjaID;
        this.impresoraID = impresoraID;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public ImpresoraID getImpresoraID() {
        return impresoraID;
    }
}

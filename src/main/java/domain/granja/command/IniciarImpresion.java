package domain.granja.command;

import co.com.sofka.domain.generic.Command;
import domain.granja.value.GranjaID;
import domain.granja.value.ImpresoraID;

public class IniciarImpresion extends Command {

    private final GranjaID granjaID;
    private final ImpresoraID impresora3DID;

    public IniciarImpresion(GranjaID granjaID, ImpresoraID impresora3DID) {
        this.granjaID = granjaID;
        this.impresora3DID = impresora3DID;
    }

    public GranjaID getGranjaID() {
        return granjaID;
    }

    public ImpresoraID getImpresora3DID() {
        return impresora3DID;
    }
}

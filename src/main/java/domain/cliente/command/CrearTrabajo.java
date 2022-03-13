package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.value.ClienteID;
import domain.cliente.value.Tipo;
import domain.cliente.value.TrabajoID;
import domain.value.Idea;

import java.util.Objects;

public class CrearTrabajo extends Command {

    private final ClienteID clienteID;
    private final TrabajoID trabajoID;
    private final Tipo tipo;

    public CrearTrabajo(ClienteID clienteID, TrabajoID trabajoID, Tipo tipo) {
        this.clienteID = clienteID;
        this.trabajoID = trabajoID;
        this.tipo = Objects.requireNonNull(tipo);
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public TrabajoID getTrabajoID() {
        return trabajoID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

package domain.cliente.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<Tipo.Props> {

    private final Fase inicial;
    private final Fase  fin;

    public Tipo(Fase inicial, Fase fin) {
        this.inicial = Objects.requireNonNull(inicial);
        this.fin = Objects.requireNonNull(fin);
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public Fase inicial() {
                return inicial;
            }

            @Override
            public Fase fin() {
                return fin;
            }
        };
    }

    public interface Props{
        Fase inicial();
        Fase fin();
    }

}

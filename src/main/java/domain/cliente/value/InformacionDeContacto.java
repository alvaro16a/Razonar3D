package domain.cliente.value;

import co.com.sofka.domain.generic.ValueObject;

public class InformacionDeContacto implements ValueObject<InformacionDeContacto.Props> {

    private final String direccion;
    private final String  telefono;
    private final String  email;


    public InformacionDeContacto(String direccion, String telefono, String email) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public Props value() {

        return new Props() {
            @Override
            public String direccion() {
                return direccion;
            }

            @Override
            public String telefono() {
                return telefono;
            }

            @Override
            public String email() {
                return email;
            }
        };
    }

    public interface Props{
        String direccion();
        String telefono();
        String email();
    }

}

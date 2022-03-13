package domain.tallerdediseno;

import co.com.sofka.domain.generic.EventChange;
import domain.tallerdediseno.event.TallerDeDisenoCreado;

import java.util.ArrayList;
import java.util.HashMap;

public class TallerDeDisenoEventChange extends EventChange {
    public TallerDeDisenoEventChange(TallerDeDiseno tallerDeDiseno) {

        apply((TallerDeDisenoCreado event) -> {
            tallerDeDiseno.diseños = new HashMap<>();
            tallerDeDiseno.diseñadores = new HashMap<>();
            tallerDeDiseno.bocetos = new ArrayList<>();
        });
    }
}

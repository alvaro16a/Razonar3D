package domain.granja;

import co.com.sofka.domain.generic.Entity;
import domain.granja.value.Estado;
import domain.granja.value.ImpresoraID;
import domain.value.Dimensiones;
import domain.value.Material;
import domain.value.Pieza;
import domain.value.Stl;
import java.util.Objects;

public class Impresora3D extends Entity<ImpresoraID> {

    private Integer horasDeImpresion;
    private Estado estado;
    private final Dimensiones volumenDeImoresion;
    private String modelo;
    private Pieza pieza;
    private Stl stl;

    public Impresora3D(ImpresoraID entityId, Dimensiones volumenDeImoresion, String modelo) {
        super(entityId);
        this.horasDeImpresion = 0;
        this.estado = new Estado();
        this.volumenDeImoresion = volumenDeImoresion;
        this.modelo =Objects.requireNonNull(modelo);
    }

    public Impresora3D(ImpresoraID entityId) {
        super(entityId);
        this.horasDeImpresion = 0;
        this.estado = new Estado();
        this.volumenDeImoresion = new Dimensiones(25,25,25); //Tamaño estandar de volumens de impresion
        this.modelo ="Ender 3 V2"; //impresora 3d con excelente relacion precio beneficio
    }

    public void terminarImpresion(){
        if(this.estado.value() == Estado.Operacional.IMPRIMIENDO){
            this.estado = new Estado(Estado.Operacional.APAGADA);
            this.horasDeImpresion += stl.value().tiempoDeImpresion();
            this.pieza=new Pieza(stl.value().nombre(),new Material());
        }else{
            throw new IllegalArgumentException("No se puede terminar una impresion que no se esta realizando");
        }
    }
    public void iniciarImpresion(Stl stl){
        if(this.estado.value()==Estado.Operacional.APAGADA) {
            this.estado = new Estado(Estado.Operacional.IMPRIMIENDO);
            this.stl= Objects.requireNonNull(stl);
        }else{
            throw new IllegalArgumentException("No se puede iniciar una impresion si la maquina no esta disponible");
        }
    }
    public void ImpresoraEnMantenimiento(){
        if(this.estado.value()==Estado.Operacional.APAGADA) {
            this.estado = new Estado(Estado.Operacional.MANTENIMIENTO);
            this.horasDeImpresion=0;
        }else{
            throw new IllegalArgumentException("Solo se puede enviar la impresora a mantenimiento cuando halla terminado el trabajo");
        }
    }
    public void ImpresoraAveriada(){
        if(this.estado.value()!=Estado.Operacional.AVERIADO) {
            this.estado = new Estado(Estado.Operacional.AVERIADO);
            this.horasDeImpresion=0;
        }else{
            throw new IllegalArgumentException("La impresora ya esta reportada como averiada");
        }
    }

    public Integer getHorasDeImpresion() {
        return horasDeImpresion;
    }

    public Estado getEstado() {
        return estado;
    }

    public Dimensiones getVolumenDeImoresion() {
        return volumenDeImoresion;
    }

    public String getModelo() {
        return modelo;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public Stl getStl() {
        return stl;
    }
}

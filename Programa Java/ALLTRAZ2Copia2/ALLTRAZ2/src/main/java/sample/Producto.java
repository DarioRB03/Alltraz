package sample;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Producto {

    private int id_producto;
    private String lote;
    private String caracteristicas;
    private LocalDate fsal;
    private LocalDate flleg;
    private LocalDate fcos;
    private LocalDate fplant;

    public Producto(String lote, String caracteristicas, LocalDate fsal, LocalDate flleg, LocalDate fcos, LocalDate fplant) {
        this.id_producto = id_producto;
        this.lote = lote;
        this.caracteristicas = caracteristicas;
        this.fsal = fsal;
        this.flleg = flleg;
        this.fcos = fcos;
        this.fplant = fplant;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public LocalDate getFsal() {
        return fsal;
    }

    public void setFsal(LocalDate fsal) {
        this.fsal = fsal;
    }

    public LocalDate getFlleg() {
        return flleg;
    }

    public void setFlleg(LocalDate flleg) {
        this.flleg = flleg;
    }

    public LocalDate getFcos() {
        return fcos;
    }

    public void setFcos(LocalDate fcos) {
        this.fcos = fcos;
    }

    public LocalDate getFplant() {
        return fplant;
    }

    public void setFplant(LocalDate fplant) {
        this.fplant = fplant;
    }
}
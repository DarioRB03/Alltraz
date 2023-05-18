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

    public LocalDateTime getFsal() {
        return fsal;
    }

    public void setFsal(LocalDateTime fsal) {
        this.fsal = fsal;
    }

    public LocalDateTime getFlleg() {
        return flleg;
    }

    public void setFlleg(LocalDateTime flleg) {
        this.flleg = flleg;
    }

    public LocalDateTime getFcos() {
        return fcos;
    }

    public void setFcos(LocalDateTime fcos) {
        this.fcos = fcos;
    }

    public LocalDateTime getFplant() {
        return fplant;
    }

    public void setFplant(LocalDateTime fplant) {
        this.fplant = fplant;
    }
}
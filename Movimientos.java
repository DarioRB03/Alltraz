package Model;

import java.util.Date;

public class Movimientos {
    private Integer id_Producto;
    private Date fecha_Plantacion;
    private Date fecha_cosecha;
    private Date fecha_LlegadaAlmacen;
    private Date fecha_SalidaAlmacen;
    private String caract_Plantacion;
    private String caract_Cosecha;
    private String caract_Llegada;
    private String caract_Salida;

    //CONSTRUCTORS

    public Movimientos(){}

    public Movimientos(Integer id_Producto, Date fecha_Plantacion, Date fecha_cosecha, Date fecha_LlegadaAlmacen, Date fecha_SalidaAlmacen, String caract_Plantacion, String caract_Cosecha, String caract_Llegada, String caract_Salida) {
        this.id_Producto = id_Producto;
        this.fecha_Plantacion = fecha_Plantacion;
        this.fecha_cosecha = fecha_cosecha;
        this.fecha_LlegadaAlmacen = fecha_LlegadaAlmacen;
        this.fecha_SalidaAlmacen = fecha_SalidaAlmacen;
        this.caract_Plantacion = caract_Plantacion;
        this.caract_Cosecha = caract_Cosecha;
        this.caract_Llegada = caract_Llegada;
        this.caract_Salida = caract_Salida;
    }

    //GETTERS AND SETTERS

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Date getFecha_Plantacion() {
        return fecha_Plantacion;
    }

    public void setFecha_Plantacion(Date fecha_Plantacion) {
        this.fecha_Plantacion = fecha_Plantacion;
    }

    public Date getFecha_cosecha() {
        return fecha_cosecha;
    }

    public void setFecha_cosecha(Date fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
    }

    public Date getFecha_LlegadaAlmacen() {
        return fecha_LlegadaAlmacen;
    }

    public void setFecha_LlegadaAlmacen(Date fecha_LlegadaAlmacen) {
        this.fecha_LlegadaAlmacen = fecha_LlegadaAlmacen;
    }

    public Date getFecha_SalidaAlmacen() {
        return fecha_SalidaAlmacen;
    }

    public void setFecha_SalidaAlmacen(Date fecha_SalidaAlmacen) {
        this.fecha_SalidaAlmacen = fecha_SalidaAlmacen;
    }

    public String getCaract_Plantacion() {
        return caract_Plantacion;
    }

    public void setCaract_Plantacion(String caract_Plantacion) {
        this.caract_Plantacion = caract_Plantacion;
    }

    public String getCaract_Cosecha() {
        return caract_Cosecha;
    }

    public void setCaract_Cosecha(String caract_Cosecha) {
        this.caract_Cosecha = caract_Cosecha;
    }

    public String getCaract_Llegada() {
        return caract_Llegada;
    }

    public void setCaract_Llegada(String caract_Llegada) {
        this.caract_Llegada = caract_Llegada;
    }

    public String getCaract_Salida() {
        return caract_Salida;
    }

    public void setCaract_Salida(String caract_Salida) {
        this.caract_Salida = caract_Salida;
    }
}

package Model;

public class Producto {
    private Integer id_Producto;
    private Integer id_TipoProducto;
    private String numero_Lote;

    //CONTRUCTORS
    public Producto(){}

    public Producto(Integer id_Producto, Integer id_TipoProducto, String numero_Lote) {
        this.id_Producto = id_Producto;
        this.id_TipoProducto = id_TipoProducto;
        this.numero_Lote = numero_Lote;
    }

    //GETTERS AND SETTER

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Integer getId_TipoProducto() {
        return id_TipoProducto;
    }

    public void setId_TipoProducto(Integer id_TipoProducto) {
        this.id_TipoProducto = id_TipoProducto;
    }

    public String getNumero_Lote() {
        return numero_Lote;
    }

    public void setNumero_Lote(String numero_Lote) {
        this.numero_Lote = numero_Lote;
    }
}

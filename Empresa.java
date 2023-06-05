package Model;

public class Empresa {
private Integer id_Empresa;
private String tipo;
private String Cif;
private String contrasenia;
private String nombreEmpresa;


    //CONSTRUCTORS
    public Empresa(){}
    public Empresa(String Cif, String contraseña) {
        this.Cif= Cif;
        this.contrasenia = contraseña;
    }
    public Empresa(Integer id_Empresa, String tipo, String cif, String contrasenia, String nombreEmpresa) {
        this.id_Empresa = id_Empresa;
        this.tipo = tipo;
        Cif = cif;
        this.contrasenia = contrasenia;
        this.nombreEmpresa = nombreEmpresa;
    }


    //GETTERS AND SETTERS
    public Integer getId_Empresa() {
        return id_Empresa;
    }

    public void setId_Empresa(Integer id_Empresa) {
        this.id_Empresa = id_Empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCif() {
        return Cif;
    }

    public void setCif(String cif) {
        Cif = cif;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}

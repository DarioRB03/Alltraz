public class Usuario {


    private int id;
    private String correo;
    private String pw;
    private boolean permisos;

    public Usuario(){}

    public Usuario(int id, String correo, String pw){
        this.id = id;
        this.correo = correo;
        this.pw = pw;
        this.permisos = permisos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public boolean isPermisos() {
        return permisos;
    }

    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }
}
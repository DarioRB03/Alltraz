package sample;

public class Empresa {

    private String cif;
    private String username_empresa;
    private int password_empresa;

    public Empresa(){}

    public Empresa(String cif, String username_empresa, int password_empresa) {
        this.cif = cif;
        this.username_empresa = username_empresa;
        this.password_empresa = password_empresa;
    }

    public String getUsername_empresa() {
        return username_empresa;
    }

    public void setUsername_empresa(String username_empresa) {
        this.username_empresa = username_empresa;
    }

    public int getPassword_empresa() {
        return password_empresa;
    }

    public void setPassword_empresa(int password_empresa) {
        this.password_empresa = password_empresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}

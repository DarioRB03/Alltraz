public class Empresa extends Usuario{

    private String cif;

    public Empresa(){}

    public Empresa(int id, String correo, String pw, boolean permisos, String cif){
        super(id, correo, pw, permisos);
        this.cif = cif;
    }
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}

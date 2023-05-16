public class Cliente extends Usuario{

    private String username;

    public Cliente(){}

    public Cliente(int id, String correo, String pw, boolean permisos, String username){
        super(id, correo, pw, permisos);
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
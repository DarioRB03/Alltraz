package Model;

public class Cliente {
    private Integer idCliente;
    private String tipoCliente;
    private String usernameCliente;
    private String passwordCliente;
    private String correoCliente;

    //CONSTRUCTORES

    public Cliente(){}

    public Cliente(String usernameCliente, String passwordCliente) {
        this.usernameCliente = usernameCliente;
        this.passwordCliente = passwordCliente;
    }

    public Cliente(Integer idCliente, String tipoCliente, String usernameCliente, String passwordCliente, String correoCliente) {
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.usernameCliente = usernameCliente;
        this.passwordCliente = passwordCliente;
        this.correoCliente = correoCliente;
    }

    //GETTERS AND SETTERS

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String mostrarUsername(){

        //MOSTRAMOS A LA HORA DE HACER EL LOGIN EL USUARIO CON EL QUE HA ENTRADO

        String m = this.usernameCliente;
        return m;
    }
}

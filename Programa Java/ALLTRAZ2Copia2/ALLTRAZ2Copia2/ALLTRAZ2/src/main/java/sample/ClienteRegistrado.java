package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClienteRegistrado {
    private String nombre;
    private String password;
    public ClienteRegistrado() {}

    public ClienteRegistrado(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void inicioSesion(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/alltraz", "root", "12345"
            );

            String querty = "Select idClientes, Nombre FROM Clientes";
            PreparedStatement smt = conn.prepareStatement(querty);

            smt.setString(1, nombre);
            smt.setString(2, password);
            smt.execute();
            smt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

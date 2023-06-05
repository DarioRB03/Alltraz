package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    //PONEMOS LA CONEXION A NULL
    static Connection conexion=null;

    //METODO PARA OBTENER CONEXION A LA BASE DE DATOS

    public Connection obtenerConexion(){
        if(conexion==null){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/alltraz", "root", "12345");

            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return conexion;
    }

    //METODO CERRAR CONEXION

    public void cerrarConexion(){
        if(conexion !=null){
            try {
                conexion.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}

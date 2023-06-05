package com.example.alltraz_defi;

import Model.Cliente;
import Model.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionClienteController implements Initializable {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField txtUsuername;
    @javafx.fxml.FXML
    private TextField txtPassword;
    @javafx.fxml.FXML
    private Button registrarse;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private Button Registrarse;

    //METODO MOSTRAR VENTANAS

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @javafx.fxml.FXML
    public void click_InicioSesion(ActionEvent actionEvent) {

        //CREAMOS VARIABLES PARA RECOGER EL TEXTO INTRODUCIDO

        String u = txtUsuername.getText().trim();
        String p = txtPassword.getText().trim();


        if (u.equals("") || p.equals("")) {

            //ALERTA CAMPOS VACIOS

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();

        } else if(u.equals("admin") && p.equals("admin")){
            //PARA ENTRAR COMO ADMINISTRADOR
            ventanaAdministrador();
        }else {

            //CONEXION A LA BASE DE DATOS_MODEL

            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();

            //CONSULTA PARA INICIO SESION

            String consulta = "Select * FROM usuario where Username='" + u + "'AND Contraseña='" + p + "'";
            Cliente c;

            try {

                //CREAMOS LA CONSULTA JUNTO A UN RESULTSET PARA BUSCAR AL CLIENTE

                Statement st = connexion.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                if (!rs.next()) {

                    //SI EL USUARIO NO EXISTE SALDRA UN ALERT

                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setTitle("Error");
                    a.setContentText("No hay registro con estos datos");
                    a.showAndWait();

                } else {

                    //RECOGERA LOS DATOS DEL CLIENTE INTRODUCIDOS

                    do {
                        c = new Cliente(
                                rs.getString("Username"),
                                rs.getString("Contraseña")
                        );
                    } while (rs.next());

                    //SI ES CORRECTO, SALDRA UN ALERT DE QUE HA ENTRADO EXITOSAMENTE

                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("Login");
                    a.setContentText("¡Bienvenido " + c.mostrarUsername() + "!");
                    a.showAndWait();

                    //Y LE MANDARA A LA VENTANA DE INFORMACION DEL PRODUCTO
                    ventanaInformacionProducto();

                }

                //CERRAMOS CONEXIONES Y RESULTS

                rs.close();
                st.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void ventanaInformacionProducto() {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InformacionProducto-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ventanaAdministrador() {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_Registrarse(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistroCliente-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

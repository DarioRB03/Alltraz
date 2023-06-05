package com.example.alltraz_defi;

import Model.Cliente;
import Model.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroClienteController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField txtUsername;
    @javafx.fxml.FXML
    private TextField txtPassword;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private Button CrearRegistro;
    @javafx.fxml.FXML
    private TextField txtCorreo;

    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InicioSesionCliente-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_CrearRegistro(ActionEvent actionEvent) {

        //CREAMOS UN REGISTRO DE UN CLIENTE NUEVO

        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (user.equals("") || pass.equals("") || correo.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "INSERT INTO usuario (Username,Contraseña,Correo_Electronico) VALUES (?,?,?)";
            Cliente cliente = new Cliente();

            try {
                PreparedStatement st = connexion.prepareStatement(consulta);
                st.setString(1, user);
                st.setString(2, pass);
                st.setString(3, correo);

                int filasNuevas = st.executeUpdate();

                if (filasNuevas == 1) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("¡Ya tienes cuenta!");
                    a.setContentText("Ahora inicia sesion para entrar en nuestra aplicacion");
                    a.showAndWait();
                }

                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

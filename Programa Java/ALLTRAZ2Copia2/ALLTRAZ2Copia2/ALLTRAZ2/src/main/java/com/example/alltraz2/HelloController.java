package com.example.alltraz2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Cliente;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloController {

        @FXML
        private TextField getMail;
        @FXML
        private TextField getUser;
        @FXML
        private TextField getPassword;
        @FXML
        private Button click_Registrarse;
        @FXML
        private Button click_InicioCliente;
        @FXML
        private Button click_InicioEmpresa;
        @FXML
        private Button click_IEAlta;
        @FXML
        private ImageView Icono1;
        private Stage stage;
        @FXML
        private ImageView Icono2;
        private Cliente cliente;
        @FXML
        private AnchorPane rootPane;


        @FXML
        public void click_Registrarse(ActionEvent actionEvent) {

            String nombre = getUser.getText();
            String password = getPassword.getText();
            String correo = getMail.getText();
            Cliente cliente = new Cliente(nombre,password,correo);
            if(nombre.isEmpty()||password.isEmpty()||correo.isEmpty()){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Debes de completar los campos para continuar");
                a.showAndWait();
            }else {
                cliente.registrarse();

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("¡Se ha creado con éxito!"+"\n"+"Inicia Sesión para continuar");
                a.show();
            }

        }

        @FXML
        public void click_InicioCliente(ActionEvent actionEvent) {

            try {
                Parent pane = FXMLLoader.load(getClass().getResource("InicioSesionCliente.fxml"));

                Scene scene = new Scene(pane);

                Stage stage = (Stage) click_InicioCliente.getScene().getWindow();

                stage.setScene(scene);

            } catch (IOException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        @FXML
        public void click_InicioEmpresa(ActionEvent actionEvent) {
        }

        @FXML
        public void click_IEAlta(ActionEvent actionEvent) {
        }




}
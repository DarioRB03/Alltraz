package com.example.alltraz;

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


        }

        @FXML
        public void click_InicioCliente(ActionEvent actionEvent) {

        }


        @FXML
        public void click_InicioEmpresa(ActionEvent actionEvent) {
        }

        @FXML
        public void click_IEAlta(ActionEvent actionEvent) {
        }




}
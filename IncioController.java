package com.example.alltraz_defi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IncioController {
    @javafx.fxml.FXML
    private Button InicioEmpresa;
    @javafx.fxml.FXML
    private Button InicioCliente;
    @javafx.fxml.FXML
    private Button ADMIN;
    @javafx.fxml.FXML
    private AnchorPane rootPane;

    @javafx.fxml.FXML
    public void InicioEmpresa(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InicioSesionEmpresa-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void InicioCliente(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InicioSesionCliente-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void btn_ADMIN(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

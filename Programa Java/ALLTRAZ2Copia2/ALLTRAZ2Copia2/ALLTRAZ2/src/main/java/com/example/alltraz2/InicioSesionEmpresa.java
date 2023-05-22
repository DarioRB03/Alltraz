package com.example.alltraz2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionEmpresa {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField getUser;
    @javafx.fxml.FXML
    private TextField getPassword;
    @javafx.fxml.FXML
    private Button InicioSesionEmpresa;
    @javafx.fxml.FXML
    private Button atras;

    @javafx.fxml.FXML
    public void click_InicioSesionEmpresa(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("INICIO.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

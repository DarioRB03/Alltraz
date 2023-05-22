package com.example.alltraz2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionCliente {
    @javafx.fxml.FXML
    private TextField getUser;
    @javafx.fxml.FXML
    private TextField getPassword;
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @FXML
    private Button atras;
    @FXML
    private Button Registrarse;

    @FXML
    public void click_InicioSesion(ActionEvent actionEvent) {
        String nombre = getUser.getText();
        String password = getPassword.getText();

    }


    @FXML
    public void click_InicioSesionEmpresa(ActionEvent actionEvent) {
    }

    @FXML
    public void click_Registrarse(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("RegistroCliente.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) Registrarse.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void click_atras(ActionEvent actionEvent) {
        try {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("INICIO.fxml"));
        this.rootPane.getChildren().setAll(pane);

    } catch (IOException ex) {
        Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}

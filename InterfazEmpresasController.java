package com.example.alltraz_defi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazEmpresasController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private ImageView imagenEmpresa;
    @javafx.fxml.FXML
    private Button anyadirProducto;
    @javafx.fxml.FXML
    private Button agregarCaracteristicas;

    @javafx.fxml.FXML
    public void click_anyadir(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ElegirProducto-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_agregarCaracteristicas(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistroProducto-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

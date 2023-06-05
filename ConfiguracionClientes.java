package com.example.alltraz_defi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionClientes {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TableView tabla;
    @javafx.fxml.FXML
    private TableColumn ID;
    @javafx.fxml.FXML
    private TableColumn tipo;
    @javafx.fxml.FXML
    private TableColumn Nombre;
    @javafx.fxml.FXML
    private TableColumn Identificacion;
    @javafx.fxml.FXML
    private TableColumn Password;
    @javafx.fxml.FXML
    private TextField filtrarCliente;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private Button modificar;
    @javafx.fxml.FXML
    private Button eliminar;

    @javafx.fxml.FXML
    public void btn_atras(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void modificar_persona(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaModificar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void eliminar_persona(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaEliminar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

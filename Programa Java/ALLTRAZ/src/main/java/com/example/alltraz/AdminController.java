package com.example.alltraz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Empresa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController {
    @javafx.fxml.FXML
    private TextField txFiltrarEmpresa;
    @javafx.fxml.FXML
    private TextField txFiltrarCliente;
    @javafx.fxml.FXML
    private Button modificar;
    @javafx.fxml.FXML
    private Button agregar;
    @javafx.fxml.FXML
    private Button eliminar;
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

    private ObservableList<Empresa> empresas = FXCollections.observableArrayList();;
    private ObservableList<Empresa> filtroempresas;
    @javafx.fxml.FXML
    private TableView tabla;

    private Empresa empresa;
    @javafx.fxml.FXML
    private AnchorPane rootPane;

    public void initialize(URL url, ResourceBundle rb){
        this.empresas = FXCollections.observableArrayList();
        filtroempresas = FXCollections.observableArrayList();

        this.tabla.setItems(empresas);

        this.ID.setCellFactory(new PropertyValueFactory("ID"));
        this.tipo.setCellFactory(new PropertyValueFactory("TIPO"));
        this.Nombre.setCellFactory(new PropertyValueFactory("Nombre"));
        this.Identificacion.setCellFactory(new PropertyValueFactory("Identificacion"));
        this.Password.setCellFactory(new PropertyValueFactory("Password"));

    }
    @javafx.fxml.FXML
    public void filtrarEmpresa(KeyEvent event) {
    }

    @javafx.fxml.FXML
    public void filtrarCliente(KeyEvent event) {
    }

    @javafx.fxml.FXML
    public void modificar_persona(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void agregar_persona(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaAgregar-View.fxml"));
            Parent root = loader.load();

            VentanaAgregarController controlador = loader.getController();
            controlador.initAtributes(empresas,empresa);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Empresa e = controlador.getEmpresa();
            if(e != null){
                this.empresas.add(e);
                this.tabla.refresh();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void eliminar_persona(ActionEvent actionEvent) {
        Empresa e = (Empresa) this.tabla.getSelectionModel().getSelectedItems();

        if(e == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Debes seleccionar una empresa");
            a.showAndWait();
        }else{
            this.empresas.remove(e);
            this.tabla.refresh();

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Se ha borrado una empresa");
            a.showAndWait();
        }
    }
}

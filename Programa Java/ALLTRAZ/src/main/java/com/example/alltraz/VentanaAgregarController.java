package com.example.alltraz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Empresa;

import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaAgregarController implements Initializable {
    @javafx.fxml.FXML
    private TextField ID;
    @javafx.fxml.FXML
    private TextField CIF;
    @javafx.fxml.FXML
    private TextField USERNAME;
    @javafx.fxml.FXML
    private TextField PASSWORD;
    @javafx.fxml.FXML
    private Button LISTO;
    @javafx.fxml.FXML
    private Button ATRAS;
    @javafx.fxml.FXML
    private AnchorPane rootPane;

    private Empresa empresa = new Empresa();
    private ObservableList<Empresa> empresas = FXCollections.observableArrayList();

    public void initAtributes(ObservableList<Empresa> empresas,Empresa empresa){
        this.empresas=empresas;
        this.empresa=empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    @javafx.fxml.FXML
    public void btn_LISTO(ActionEvent actionEvent) {
        Integer Id = Integer.parseInt(this.ID.getText());
        String Cif = this.CIF.getText();
        String tipo = "Empresa";
        String user = this.USERNAME.getText();
        String pass = this.PASSWORD.getText();

        Empresa e = new Empresa(Id,tipo,Cif,user,pass);

        if (!empresas.contains(e)){
            if(this.empresa!=null){
            this.empresa=e;

            this.empresa.setID(Id);
            this.empresa.setTipo("Empresa");
            this.empresa.setCif(Cif);
            this.empresa.setUsername_empresa(user);
            this.empresa.setPassword_empresa(pass);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setTitle("Informacion");
            a.setContentText("Se ha añadido correctamente");
            a.showAndWait();

            Stage stage = (Stage) this.LISTO.getScene().getWindow();
            stage.close();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("La empresa ya existe");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void click_ATRAS(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ADMIN.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

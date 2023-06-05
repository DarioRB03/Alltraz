package com.example.alltraz_defi;

import Model.DataBase;
import Model.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class VentanaAgregarController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField ID;
    @javafx.fxml.FXML
    private TextField CIF;
    @javafx.fxml.FXML
    private TextField PASSWORD;
    @javafx.fxml.FXML
    private Button LISTO;
    @javafx.fxml.FXML
    private Button ATRAS;

    private Empresa empresa = new Empresa();
    private ObservableList<Empresa> empresas = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void btn_LISTO(ActionEvent actionEvent) {

        //RECOGEMOS DATOS

        String nombreEmpresa = ID.getText().trim();
        String cif = CIF.getText().trim();
        String pass = PASSWORD.getText().trim();


        //SI ESTAN VACIOS QUE MUESTREN UN ALERT
        if (pass.equals("") || nombreEmpresa.equals("") || cif.equals("")) {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();

        } else {
            //SI NO QUE HAGA LA CONEXION Y LA CONSULTA

            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "INSERT INTO empresa (Cif,Contraseña,NombreEmpresa) VALUES (?,?,?)";
            Empresa empresa = new Empresa();

            try {
                PreparedStatement st = connexion.prepareStatement(consulta);
                st.setString(1, cif);
                st.setString(2, pass);
                st.setString(4, nombreEmpresa);

                int filasNuevas = st.executeUpdate();

                if (filasNuevas == 1) {
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("¡Ya tiene cuenta!");
                    a.setContentText("Ahora inicia sesion para entrar en nuestra aplicacion");
                    a.showAndWait();
                }

                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @javafx.fxml.FXML
    public void click_ATRAS(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Admin-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

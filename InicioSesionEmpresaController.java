package com.example.alltraz_defi;

import Model.DataBase;
import Model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionEmpresaController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField getUser;
    @javafx.fxml.FXML
    private TextField getPassword;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private Button inicioSesion;

    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_InicioSesionEmpresa(ActionEvent actionEvent) {

        //Metodo para iniciar sesion como "Empresa"

        //Recogemos datos
        String cif = getUser.getText().trim();
        String pass = getPassword.getText().trim();

        //Si estan vacios que muestren un alert
        if (cif.equals("") || pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {

            //Si no que hagan conexion a la base de datos y la consulta
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "Select * FROM empresa where Cif='" + cif + "'AND Contraseña='" + pass + "'";
            Empresa empresa = new Empresa();

            try {
                Statement st = connexion.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                if (!rs.next()) {
                    //Si no hay ningun dato en la base de datos que muestre un error
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setTitle("Error");
                    a.setContentText("No hay registro con estos datos");
                    a.showAndWait();
                } else {
                    do {
                        //Recorre las columnas de la tabla de la base de datps
                        empresa = new Empresa(
                                rs.getString("Cif"),
                                rs.getString("Contraseña")
                        );
                    } while (rs.next());

                    //Si hay datos y son iguales un alert de que el login ha sido exitoso
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("Aviso");
                    a.setContentText("Login existoso ");
                    a.showAndWait();

                    //Y te manda a la interfaz
                    ventanaInterfazEmpresas();

                }
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ventanaInterfazEmpresas(){

        //Metodo para mostrar pantalla

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfazEmpresas-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

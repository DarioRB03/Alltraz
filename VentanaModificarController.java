package com.example.alltraz_defi;

import Model.DataBase;
import Model.Empresa;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaModificarController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField User;
    @javafx.fxml.FXML
    private TextField Identificacion;
    @javafx.fxml.FXML
    private TextField contraseña;
    @javafx.fxml.FXML
    private Button LISTO;
    @javafx.fxml.FXML
    private Button ATRAS;
    @javafx.fxml.FXML
    private TextField ID;
    @javafx.fxml.FXML
    private Button BuscarId;

    @javafx.fxml.FXML
    public void btn_LISTO(ActionEvent actionEvent) {

        //EN ESTE BOTON LO QUE HAREMOS SERA UNA MODIFICACIION DE LA EMPRESA POR SI OCURRE ALGO

        String nombreEmpresa1 = User.getText();
        String cif1 = Identificacion.getText();
        String pass1 = contraseña.getText();
        String id1 = ID.getText();


        if (pass1.equals("") || nombreEmpresa1.equals("") || cif1.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "UPDATE empresa SET Cif=?,Contraseña=?,NombreEmpresa=? where Id_empresa=?";
            Empresa empresa = new Empresa();

            try {
                PreparedStatement st = connexion.prepareStatement(consulta);
                st.setString(1, cif1);
                st.setString(2, pass1);
                st.setString(3, nombreEmpresa1);
                st.setString(4, id1);

                int filasNuevas = st.executeUpdate();

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

    @javafx.fxml.FXML
    public void btn_BuscarID(ActionEvent actionEvent) {

        //EN ESTE METODO BUSCAREMOS EL ID DE LA EMPRESA Y LO MOSTRAREMOS

        String nombreEmpresa = User.getText().trim();
        String cif = Identificacion.getText().trim();
        String pass = contraseña.getText().trim();

        DataBase db = new DataBase();
        Connection connexion = db.obtenerConexion();


        String consulta = "Select * FROM empresa where Id_empresa= ?";
        Empresa empresa = new Empresa();

        try {
            PreparedStatement st = connexion.prepareStatement(consulta);
            String id=ID.getText().trim();
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String nombreempresa1 = rs.getString("NombreEmpresa");
                String cif1 = rs.getString("Cif");
                String pass1 = rs.getString("Contraseña");

                User.setText(nombreempresa1);
                Identificacion.setText(cif1);
                contraseña.setText(pass1);
            }


            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

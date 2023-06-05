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

public class VentanaEliminarView {
    @javafx.fxml.FXML
    private TextField id_eliminar;
    @javafx.fxml.FXML
    private TextField nombreEmpresa;
    @javafx.fxml.FXML
    private TextField cif;
    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private Button eliminarEmpresa;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private Button buscar;
    @javafx.fxml.FXML
    private AnchorPane rootPane;

    @javafx.fxml.FXML
    public void btn_eliminarEmpresa(ActionEvent actionEvent) throws SQLException {

        //Metodo para eliminar el id introducido

        DataBase db = new DataBase();
        Connection connexion = db.obtenerConexion();


        String consulta = "DELETE FROM empresa where Id_empresa= ?";
        PreparedStatement st = connexion.prepareStatement(consulta);
        String id=id_eliminar.getText().trim();
        st.setString(1, id);

        int filasEliminadas = st.executeUpdate();
        if(filasEliminadas == 1){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText(null);
            a.setTitle("Aviso");
            a.setContentText("Empresa Eliminada");
            a.showAndWait();
        }

        st.execute();
    }

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
    public void btn_buscar(ActionEvent actionEvent) {

        //Aqui buscaremos el cif,nombre de la empresa y contraseña y lo mostraremos

        String ne = nombreEmpresa.getText().trim();
        String Cif = cif.getText().trim();
        String pass = password.getText().trim();

        DataBase db = new DataBase();
        Connection connexion = db.obtenerConexion();


        String consulta = "Select * FROM empresa where Id_empresa= ?";
        Empresa empresa = new Empresa();

        try {
            PreparedStatement st = connexion.prepareStatement(consulta);
            String id=id_eliminar.getText().trim();
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String nombreempresa1 = rs.getString("NombreEmpresa");
                String cif1 = rs.getString("Cif");
                String pass1 = rs.getString("Contraseña");

                nombreEmpresa.setText(nombreempresa1);
                cif.setText(cif1);
                password.setText(pass1);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

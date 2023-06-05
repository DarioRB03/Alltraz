package com.example.alltraz_defi;

import Model.DataBase;
import Model.Empresa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin implements Initializable {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private Button modificar;
    @javafx.fxml.FXML
    private Button agregar;
    @javafx.fxml.FXML
    private Button eliminar;
    @javafx.fxml.FXML
    private TableView<Empresa> tabla;
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
    private Button atras;
    private Empresa empresa;

    @javafx.fxml.FXML
    public void modificar_persona(ActionEvent actionEvent) {

        //TE MANDA A LA VENTANA DE MODIFICAR

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaModificar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void agregar_persona(ActionEvent actionEvent) {

        //TE MANDA A LA VENTANA DE AGREGAR

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaAgregar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void eliminar_persona(ActionEvent actionEvent) {

        //TE MANDA A LA VENTANA ELIMINAR

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaEliminar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void btn_atras(ActionEvent actionEvent) {

        //TE DEVUELVE A ADMIN VIEW

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz_defi.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //METODO PARA MOSTRAR LISTA DE EMPRESAS EN LA TABLA
    public ObservableList<Empresa> getEmpresas() {
        var sql = "Select * From empresa";
        ObservableList<Empresa> empresasList = FXCollections.observableArrayList();

        try {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();
            PreparedStatement st = db.obtenerConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Integer id_ = Integer.valueOf(rs.getString("Id_empresa"));
                String tip = rs.getString("Tipo");
                String ne = rs.getString("NombreEmpresa");
                String cif = rs.getString("Cif");
                String pas = rs.getString("Contraseña");
                Empresa e = new Empresa(id_, tip, ne, cif, pas);
                empresasList.add(e);

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresasList;
    }

    public void llenarTabla() {
        ObservableList<Empresa> listaempresas = getEmpresas();


        this.ID.setCellValueFactory(new PropertyValueFactory("id_Empresa"));
        this.tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.Nombre.setCellValueFactory(new PropertyValueFactory("nombreEmpresa"));
        this.Identificacion.setCellValueFactory(new PropertyValueFactory("Cif"));
        this.Password.setCellValueFactory(new PropertyValueFactory("contrasenia"));


        ObservableList<Empresa> p = FXCollections.observableArrayList();
        tabla.setItems(listaempresas);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarTabla();
    }
}

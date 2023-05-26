package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sample.Producto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class RegistroProductoController {


    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField fLtPr;
    @javafx.fxml.FXML
    private TextArea prodcar;
    @javafx.fxml.FXML
    private Button botonSubirImagen;
    @javafx.fxml.FXML
    private Button botonRegistrarProducto;
    @javafx.fxml.FXML
    private DatePicker PickPlantacion;
    private LocalDate fsal, flleg, fcos, fplant;
    @javafx.fxml.FXML
    private DatePicker PickCosecha;
    @javafx.fxml.FXML
    private DatePicker PickLlALm;
    @javafx.fxml.FXML
    private DatePicker PickSalida;

    @javafx.fxml.FXML
    public void onBotonRegistrarProducto(ActionEvent actionEvent){
        String lote, caracteristicas;

        lote = fLtPr.getText();
        caracteristicas = prodcar.getText();

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Datos");
        a.setHeaderText("Confirmación de datos.");
        a.setResizable(false);
        a.setContentText("Fecha de plantación: "+ fplant.toString() + "\nFecha de cosecha: "+fcos.toString() + "\n" +
                "Fecha de llegada al almacén: " + flleg.toString() + "\nFecha salida almacén: " + fsal.toString() + "\n" +
                "Número de lote: " + lote + "\nCaracterísticas: " + caracteristicas);

        Optional<ButtonType> result = a.showAndWait();

        if(result.get() == ButtonType.OK){
            Producto producto = new Producto(lote, caracteristicas, fsal, flleg, fcos, fplant);
            /*
            GUARDAR EN BASE DE DATOS

            PONER PAGINA HOME
             */
        }
    }

    @javafx.fxml.FXML
    public void onBotonSubirImagen(ActionEvent actionEvent) {

    }


    @javafx.fxml.FXML
    public void onPickPlantacion(ActionEvent actionEvent) {
        fplant = PickPlantacion.getValue();
    }

    @javafx.fxml.FXML
    public void onPickCosecha(ActionEvent actionEvent) {
        fcos = PickCosecha.getValue();
    }

    @javafx.fxml.FXML
    public void onPickSalida(ActionEvent actionEvent) {
        fsal = PickSalida.getValue();
    }

    @javafx.fxml.FXML
    public void onPickLlAlm(ActionEvent actionEvent) {
        flleg = PickLlALm.getValue();
    }
}

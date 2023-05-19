package com.example.alltraz2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegistroProducto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Parent root = fxmlLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("ALLTRAZ");
        stage.getIcons().add(new Image("C:\\Users\\Darío\\Desktop\\ProyectoIntegrado1\\Programa Java\\ALLTRAZ2Copia2\\ALLTRAZ2\\src\\main\\resources\\com\\example\\alltraz2\\Miproyecto.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
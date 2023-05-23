package com.example.alltraz2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("INICIO.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),875,598);
        Parent root = fxmlLoader.load(getClass().getResource("INICIO.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("ALLTRAZ");
        stage.getIcons().add(new Image("C:\\Users\\eduar\\Desktop\\ALLTRAZDEFINITIVO\\src\\main\\resources\\com\\example\\alltrazdefinitivo\\Miproyecto.png"));
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args) {
        launch();
    }
}
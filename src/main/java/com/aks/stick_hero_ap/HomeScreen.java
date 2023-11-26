package com.aks.stick_hero_ap;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HomeScreen.class.getResource("HomeScreen.fxml"));
        //Parent root=fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("javafx.version"));
    }
}
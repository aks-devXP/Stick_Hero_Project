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
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;


/*This is the main class of the code which is used to run the game,
in this code there is a main function and a start function, both of which are mandatory
to run a javafx program
 */
public class HomeScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        The FXMLLOADER loads the fxml file for the homescreen and then it is used loaded into the scene
        Then this scene is shown using the stage object.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(HomeScreen.class.getResource("HomeScreen.fxml"));
        //Parent root=fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
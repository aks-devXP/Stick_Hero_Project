package com.aks.stick_hero_ap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerHomeScreenController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MusicController musicController;

    //@FXML
    Image image= new Image(getClass().getResourceAsStream("Reference.png"));

    Image unmuteImage=new Image(getClass().getResourceAsStream("Sound.png"));
    Image muteImage=new Image(getClass().getResourceAsStream("Mute.png"));

    boolean isMuted=false;

    @FXML
    ImageView backgroundImageView;

    @FXML
    Label newGameLabel, loadGameLabel;

    double targetWidth=300;
    double targetHeight=500;

    double scaleFactor=targetHeight/ image.getHeight();

    public void muteUnmute() {
        if(AudioManager.isMuted()) { // if sound is muted
            musicController.stopAudio(); // stops the audio
        }
        else {
            musicController.playAudio(); //plays the audio
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        musicController = new MusicController(getClass().getResource("starting.mp3").toExternalForm()); //Setting up Music Controller for Home Screen
        backgroundImageView.setFitWidth(image.getWidth()*scaleFactor);
        backgroundImageView.setFitHeight(targetHeight);
        //backgroundImageView.setPreserveRatio(true);
        //backgroundImageView.setViewport(new javafx.geometry.Rectangle2D(174,0,targetWidth,targetHeight));
        backgroundImageView.setImage(image);
        newGameLabel.setText("New\nGame");
        loadGameLabel.setText("Load\nGame");
        muteUnmute(); //Setting Mute-Condition as per selected by Player
    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
        Parent root= fxmlLoader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        SinglePlayerGameScreenController gameController=fxmlLoader.getController();
        gameController.getTheRootFromPreviousScene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio(); // Stopping the current audio before changing scene
        stage.show();
    }


    public void switchToHomeScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        Parent root=fxmlLoader.load();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        HomeScreenController homeScreenController=fxmlLoader.getController();
        homeScreenController.getMusicController().stopAudio();
        homeScreenController.initialiseSound();
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio(); // Stopping the current audio before changing scene
        stage.show();
    }

    public void switchToLoadScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("LoadScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio(); // Stopping the current audio before changing scene
        stage.show();
    }


}

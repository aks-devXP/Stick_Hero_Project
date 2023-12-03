package com.aks.stick_hero_ap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController extends GameController implements DisplayScreens,Initializable,Sound {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private MusicController musicController;
    Image image = new Image(getClass().getResourceAsStream("Player Fell Down.jpg"));

    @FXML
    ImageView backgroundImageView;

    double targetWidth = 300;
    double targetHeight = 500;

    double scaleFactor = targetWidth / image.getWidth();

    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    void revive() {
    }

    void showScores() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //pausePane.setVisible(true);
        //gamePane.setVisible(false);
        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);
        initialiseSound();

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);

    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio();
        stage.show();
    }

    public void switchToHomeScreen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio();
        stage.show();
    }

    @Override
    public void initialiseSound() {
        musicController = new MusicController(getClass().getResource("fallen.mp3").toExternalForm());
        muteUnmute();
    }

    public void muteUnmute() {
        if(AudioManager.isMuted()) { // if sound is muted
            musicController.stopAudio(); // stops the audio
        }
        else {
            musicController.playAudio(); //plays the audio
        }
    }
}

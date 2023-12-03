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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenController extends HomeScreen implements Sound,DisplayScreens, Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int totalCherries;
    private MusicController musicController;
    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
    }

    public int getTotalCherries() {
        return totalCherries;
    }

    public void setTotalCherries(int totalCherries) {
        this.totalCherries = totalCherries;
    }

    @Override
    public void initialiseSound(){ //setting up the sound
        musicController = new MusicController(getClass().getResource("starting.mp3").toExternalForm());
        if(!AudioManager.isMuted()) musicController.playAudio();
        else musicController.stopAudio();
        setSoundImage();
    }

    Image image= new Image(getClass().getResourceAsStream("BG-1st.jpg"));
    Image unmuteImage=new Image(getClass().getResourceAsStream("Sound.png"));
    Image muteImage=new Image(getClass().getResourceAsStream("Mute.png"));

    @FXML
    ImageView backgroundImageView;

    @FXML
    private ImageView muteUnmuteImageView;

    @FXML
    Label singlePlayerLabel;

    @FXML
    Label twoPlayerLabel;

    double targetWidth=300;
    double targetHeight=500;

    double scaleFactor=targetHeight/ image.getHeight();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setMute(false);
        backgroundImageView.setFitWidth(image.getWidth()*scaleFactor);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setImage(image);
        singlePlayerLabel.setText("Single\nPlayer");
        twoPlayerLabel.setText("Two\nPlayer");
        initialiseSound();
        setTotalCherries(0);
    }


    public void switchToSinglePlayerHomeScreen(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerHomeScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio();
        stage.show();
    }

    @Override
    public void muteUnmute() {
        AudioManager.setMuted(!AudioManager.isMuted()); //changes the state of the state of current Sound
        if(AudioManager.isMuted()) { // if sound is muted
            setSoundImage(); //set Sound image to mute
            musicController.stopAudio(); // stops the audio
        }
        else {
            setSoundImage(); // Set sound image to Sound
            musicController.playAudio(); //plays the audio
        }
    }

    public void setSoundImage(){
        if(AudioManager.isMuted()) muteUnmuteImageView.setImage(muteImage);
        else muteUnmuteImageView.setImage(unmuteImage);
    }

    //void muteUnmute(){};
    void singlePlayer(){};
    void twoPlayer(){};

    @Override
    public void display() {
    }

    @Override
    public void nextDisplay() {

    }

    @Override
    public void prevDisplay() {

    }
}

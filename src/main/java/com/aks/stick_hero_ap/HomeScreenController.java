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

public class HomeScreenController extends HomeScreen implements MusicPlayer,DisplayScreens, Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private boolean mute;
    private int totalCherries;
    private Media media;
    private MediaPlayer mediaPlayer;

    private boolean soundInitialised=false;

    public boolean getMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public int getTotalCherries() {
        return totalCherries;
    }

    public void setTotalCherries(int totalCherries) {
        this.totalCherries = totalCherries;
    }

    public void initialiseSound(){
        media = new Media(getClass().getResource("starting.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
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
        setMute(false);
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
        stage.show();
    }

    public void muteUnmute() {
        if(!getMute()){
            muteUnmuteImageView.setImage(muteImage);
            setMute(true);
            mediaPlayer.pause();
        }

        else{
            muteUnmuteImageView.setImage(unmuteImage);
            setMute(false);
            mediaPlayer.play();
        }
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

    @Override
    public void startMusic(MediaPlayer mediaPlayer) {
        mediaPlayer.play();
    }

    @Override
    public void stopMusic(MediaPlayer mediaPlayer) {
        mediaPlayer.pause();
    }
}

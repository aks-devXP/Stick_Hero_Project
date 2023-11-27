package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameOverController extends GameController implements MusicPlayer,DisplayScreens{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Media media;
    private MediaPlayer mediaPlayer;

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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }



    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    void revive(){};
    void showScores(){};

    @Override
    public void startMusic(MediaPlayer mediaPlayer) {

    }

    @Override
    public void stopMusic(MediaPlayer mediaPlayer) {

    }
}

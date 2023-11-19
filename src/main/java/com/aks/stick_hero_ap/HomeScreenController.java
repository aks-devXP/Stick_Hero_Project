package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class HomeScreenController extends HomeScreen implements MusicPlayer,DisplayScreens{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private boolean mute;
    private int totalCherries;

    private Media media;
    private MediaPlayer mediaPlayer;

    void muteUnmute(){};
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
    public void startMusic() {

    }

    @Override
    public void stopMusic() {

    }
}

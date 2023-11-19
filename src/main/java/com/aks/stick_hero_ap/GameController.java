package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;

public class GameController extends HomeScreenController implements DisplayScreens, MusicPlayer{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Line pole;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    void startSinglePlayer(){};
    void startTwoPlayer(){};

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

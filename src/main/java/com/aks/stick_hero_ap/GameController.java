package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;

public class GameController extends Player implements DisplayScreens, MusicPlayer{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Line pole;
    private File file;
    private Media media;
    private Player player;
    private MediaPlayer mediaPlayer;
    void startSinglePlayer(){ //Implement Logics for Single Player Mode
        while(!isFallen()){ // Incomplete Function
            initPlatforms();
            initCherry();
            startExtendingPole();
            movePlayer();

        }

    };
    void startTwoPlayer(){ //Implement Logics for Two Player Mode

    };

    private Player[] saveSlots = {null,null,null,null}; // Storing Save Slots for Single Player Mode

    public Player[] getSaveSlots() {
        return saveSlots;
    }

    public void setSaveSlots(Player[] saveSlots) {
        this.saveSlots = saveSlots;
    }

    //Assuming that we would always put 1-4 in serial
    void addsaveGame(int serial,Player player1){
        getSaveSlots()[serial-1] = player1; //Save new Player into Save Slot Array
    };

    void removeSaveGame(int serial){
        getSaveSlots()[serial-1] = null; //Change Save Slot back to null
    };

    public Player getPlayer(){
        return player;
    }

    public Scene getScene() {
        return scene;
    }

    public void makeScene(){
        this.scene = new Scene(new Pane()); //temp scene
    }

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

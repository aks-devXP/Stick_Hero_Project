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

public class GameController extends Player implements DisplayScreens{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Line pole;
    private File file;
    private Media media;
    private Player player;
    private MediaPlayer mediaPlayer;
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
    public void addSaveSlot(int serial, Player player1) {
        getSaveSlots()[serial-1] = player1; //Save new Player into Save Slot Array
    }

    public void removeSaveSlot(int serial){
        getSaveSlots()[serial-1] = null; //Change Save Slot back to null
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
}

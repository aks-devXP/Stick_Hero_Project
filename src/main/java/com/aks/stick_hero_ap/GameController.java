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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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

    public void removeSaveSlot(int serial){
        getSaveSlots()[serial-1] = null; //Change Save Slot back to null
    }

    public Player getSaveGame(int serial){ // Pass values from 1-4
        Player player = null;
        ObjectInputStream in = null;
        String val = String.valueOf(serial);
        try{
            in = new ObjectInputStream(new FileInputStream("Saves\\" + val + ".txt"));
            player = (Player) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to Retrieve Save Game File due to: " + e.getMessage());
            return null; // If the file is not found return null
        }
        return player; // Return object of Player
    }

    public void addSaveSlots(){ // Function to save all the saves into SaveSlots.
        for(int i = 0; i<4; i++){
            getSaveSlots()[i] = getSaveGame(i+1);
            System.out.println("Completed All the Saves into Save Slots.");
        }
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

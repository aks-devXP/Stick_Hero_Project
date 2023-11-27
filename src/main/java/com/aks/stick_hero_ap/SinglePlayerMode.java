package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SinglePlayerMode extends GameController implements DisplayScreens,MusicPlayer{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Player player;
    void loadGame(int serial){
        this.player = getSaveSlots()[serial];
    }

    void save_Game(int serial){
        saveGame(serial,this.player);
    }

    void removeSave(int serial){
        removeSaveGame(serial);
    }
    void startPlayer(){
        startSinglePlayer();
    };
    void showResult(){};
}

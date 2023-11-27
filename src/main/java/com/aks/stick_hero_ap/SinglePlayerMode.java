package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SinglePlayerMode extends GameController implements DisplayScreens,MusicPlayer{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Player player;

    // Assuming Serial is from 1-4 always
    void loadGame(int serial){
        this.player = getSaveSlots()[serial-1];
    }

    void save_Game(int serial){
        addsaveGame(serial-1,this.player);
    }

    void removeSave(int serial){
        removeSaveGame(serial-1);
    }
    void startPlayer(){
        startSinglePlayer();
    };
    void showResult(){};
}

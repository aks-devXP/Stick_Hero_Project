package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SinglePlayerMode extends GameController implements DisplayScreens,SaveData{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Player player;

    // Assuming Serial is from 1-4 always
    void loadGame(int serial){
        this.player = getSaveSlots()[serial-1];
    }
    void startPlayer(){
        startSinglePlayer();
    };
    void showResult(){};

    @Override
    public void addSaveGame(int serial, Player player) {
        addSaveSlot(serial,player);
    }

    @Override
    public void removeSaveGame(int serial) {
        removeSaveSlot(serial);
    }

    @Override
    public Player getSaveGame(int serial) {
        return getSaveSlots()[serial-1];
    }
}

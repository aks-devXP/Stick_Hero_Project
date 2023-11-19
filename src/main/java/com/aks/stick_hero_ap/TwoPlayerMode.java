package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TwoPlayerMode extends GameController implements MusicPlayer,DisplayScreens{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Player player1;
    private Player player2;
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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    void startPlayer1(){};
    void stopPlayer1(){};
    void startPlayer2(){};
    void stopPlayer2(){};

    void showResult(){};
}

package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SaveScreenController extends PauseController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int score;
    private int cherry;

    @Override
    public Stage getStage() {
        return stage;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    @Override
    public void setRoot(Parent root) {
        this.root = root;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCherry() {
        return cherry;
    }

    public void setCherry(int cherry) {
        this.cherry = cherry;
    }

    void saveGame(){};

    void removeSaveGame(){};
}

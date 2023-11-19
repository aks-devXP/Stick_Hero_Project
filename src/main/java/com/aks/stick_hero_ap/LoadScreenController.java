package com.aks.stick_hero_ap;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoadScreenController extends HomeScreenController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int score;
    private int cherry;

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

    void loadSave(){};
    void deleteSave(){};
}

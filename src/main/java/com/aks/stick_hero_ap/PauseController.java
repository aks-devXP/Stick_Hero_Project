package com.aks.stick_hero_ap;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PauseController extends GameController implements DisplayScreens,MusicPlayer{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Media media;
    private MediaPlayer mediaPlayer;

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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public int getSavePoleLength() {
        return savePoleLength;
    }

    public void setSavePoleLength(int savePoleLength) {
        this.savePoleLength = savePoleLength;
    }

    public boolean isSaveIsMoving() {
        return saveIsMoving;
    }

    public void setSaveIsMoving(boolean saveIsMoving) {
        this.saveIsMoving = saveIsMoving;
    }

    public boolean isSaveIsFlipped() {
        return saveIsFlipped;
    }

    public void setSaveIsFlipped(boolean saveIsFlipped) {
        this.saveIsFlipped = saveIsFlipped;
    }

    public boolean isSaveIsGameOver() {
        return saveIsGameOver;
    }

    public void setSaveIsGameOver(boolean saveIsGameOver) {
        this.saveIsGameOver = saveIsGameOver;
    }

    public int getSaveCherriesCollected() {
        return saveCherriesCollected;
    }

    public void setSaveCherriesCollected(int saveCherriesCollected) {
        this.saveCherriesCollected = saveCherriesCollected;
    }

    public int getSaveScore() {
        return saveScore;
    }

    public void setSaveScore(int saveScore) {
        this.saveScore = saveScore;
    }

    public Platform getSaveFirstPlatform() {
        return saveFirstPlatform;
    }

    public void setSaveFirstPlatform(Platform saveFirstPlatform) {
        this.saveFirstPlatform = saveFirstPlatform;
    }

    public Platform getSaveSecondPlatform() {
        return saveSecondPlatform;
    }

    public void setSaveSecondPlatform(Platform saveSecondPlatform) {
        this.saveSecondPlatform = saveSecondPlatform;
    }

    public double getSavePlatformDistance() {
        return savePlatformDistance;
    }

    public void setSavePlatformDistance(double savePlatformDistance) {
        this.savePlatformDistance = savePlatformDistance;
    }

    public double getSavePlayerPosition() {
        return savePlayerPosition;
    }

    public void setSavePlayerPosition(double savePlayerPosition) {
        this.savePlayerPosition = savePlayerPosition;
    }

    private int savePoleLength;
    private boolean saveIsMoving;
    private boolean saveIsFlipped;
    private boolean saveIsGameOver;
    private int saveCherriesCollected;
    private int saveScore;
    private Platform saveFirstPlatform;
    private Platform saveSecondPlatform;
    private double savePlatformDistance;
    private double savePlayerPosition;

    void pause(){};
    void unpause(){};

    void save(int savePoleLength, boolean saveIsMoving, boolean saveIsFlipped, boolean saveIsGameOver, int saveCherriesCollected, int saveScore, Platform saveFirstPlatform, Platform saveSecondPlatform, double savePlatformDistance, double savePlayerPosition) {
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
    public void startMusic() {

    }

    @Override
    public void stopMusic() {

    }
}

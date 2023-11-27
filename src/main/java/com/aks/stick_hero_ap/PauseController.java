package com.aks.stick_hero_ap;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseController extends GameController implements DisplayScreens,MusicPlayer, Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Media media;
    private MediaPlayer mediaPlayer;

    Image image= new Image(getClass().getResourceAsStream("Game Screenshot.jpg"));

    @FXML
    ImageView backgroundImageView;

    double targetWidth=300;
    double targetHeight=500;

    double scaleFactor=targetWidth/ image.getWidth();

    //@FXML
    //AnchorPane pausePane;

    @FXML
    AnchorPane gamePane;

    //@FXML
    //Polygon resumeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //pausePane.setVisible(true);
        //gamePane.setVisible(false);

        backgroundImageView.setImage(image);

        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);



    }

    public Player getSavePlayer(int serial){
        return getSaves()[serial];
    }

    public Player[] getSave(){
        return getSaves();
    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToHomeScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToSaveGameScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("SaveGameScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

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
    public void startMusic(MediaPlayer mediaPlayer) {

    }

    @Override
    public void stopMusic(MediaPlayer mediaPlayer) {

    }
}

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

public class PauseController extends SinglePlayerGameScreenController implements DisplayScreens,Initializable,SaveData,Sound {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private MusicController musicController;
    private MusicAdapter musicAdapter;

    @Override
    public int getCurrentScore() {
        return currentScore;
    }

    @Override
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    private int currentScore=0,cherries=0;

    Image image= new Image(getClass().getResourceAsStream("BackgroundImage1.jpg"));

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
        //backgroundImageView.setOpacity(0);
        initialiseSound();

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);



    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));

        //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        Parent root=fxmlLoader.load();
        SinglePlayerGameScreenController singlePlayerGameScreenController=fxmlLoader.getController();
        singlePlayerGameScreenController.setCurrentScoreAndShow(currentScore);
        singlePlayerGameScreenController.setCherriesAndShow(cherries);
        singlePlayerGameScreenController.setWasPaused(true);
//        Player p1=singlePlayerGameScreenController.getPlayerInstance();
//        p1.setCherriesCollected(cherries);
//        p1.setCurrentScore(currentScore);

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // Stopping the current audio before changing scene
        stage.show();
    }


    public void switchToSinglePlayerGameScreenAndInitialise(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));

        //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        Parent root=fxmlLoader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // Stopping the current audio before changing scene
        stage.show();
    }



    public void switchToHomeScreen(ActionEvent event) throws IOException {
        musicAdapter.muteSound();
        Parent root= FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // Stopping the current audio before changing scene
        stage.show();
    }

    public void switchToSaveGameScreen(ActionEvent event) throws IOException {
        musicAdapter.muteSound();
        Parent root= FXMLLoader.load(getClass().getResource("SaveGameScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // Stopping the current audio before changing scene
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

    @Override // Save Game in the slots
    public void addSaveGame(int serial, Player player){
        //addSaveSlot(serial,player);
    }

    @Override // Deleting the Save Game from Slots
    public void removeSaveGame(int serial) {
        removeSaveSlot(serial);
    }

    @Override // Load Game from Slots (Would not be used here)
    public Player getSaveGame(int serial) {
        return getSaveSlots()[serial-1];
    }

    public void setMusicAdapter(){
        this.musicAdapter = new MusicAdapter(this.musicController,"paused.mp3");
    }

    @Override
    public void initialiseSound() {
        setMusicAdapter();
        musicAdapter.initialiseSound();
    }

    public void muteUnmute() {
        musicAdapter.muteUnmute();
    }
}

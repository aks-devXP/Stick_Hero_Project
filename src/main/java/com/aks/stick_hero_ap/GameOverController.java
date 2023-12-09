package com.aks.stick_hero_ap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController extends GameController implements DisplayScreens,Initializable,Sound {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private MusicController musicController;
    private MusicAdapter musicAdapter;

    public int getNumberOfCherries() {
        return numberOfCherries;
    }

    public void setNumberOfCherries(int numberOfCherries) {
        this.numberOfCherries = numberOfCherries;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int numberOfCherries=0,score=0,bestScore=0;

    Image image = new Image(getClass().getResourceAsStream("BackgroundImage1.jpg"));

    @FXML
    ImageView backgroundImageView;

    @FXML
    private Label currentScoreLabel,bestScoreLabel,cherriesLabel;

    double targetWidth = 300;
    double targetHeight = 500;

    double scaleFactor = targetWidth / image.getWidth();

    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
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

    void revive() {
    }

    void showScores() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //pausePane.setVisible(true);
        //gamePane.setVisible(false);
        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.setOpacity(1);
        //currentScoreLabel.setText("Current: "+String.valueOf(score));

        initialiseSound();

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);

    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        Parent root=fxmlLoader.load();
        SinglePlayerGameScreenController singlePlayerGameScreenController=fxmlLoader.getController();
        singlePlayerGameScreenController.setBestScore(bestScore);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound();
        stage.show();
    }

    public void switchToHomeScreen(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound();
        stage.show();
    }

    public void setCurrentScoreLabel(int score){
        this.score=score;
        currentScoreLabel.setText("Current: "+String.valueOf(score));
    }

    public void setCherries(int numCherry){
        this.numberOfCherries=numCherry;
        cherriesLabel.setText("Cherries: "+String.valueOf(numberOfCherries));
    }

    public void setBestScore(int bestScore){
        this.bestScore=bestScore;
        bestScoreLabel.setText("Best: "+bestScore);
    }

    public void setMusicAdapter(){
        this.musicAdapter = new MusicAdapter(this.musicController,"data.mp3");
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

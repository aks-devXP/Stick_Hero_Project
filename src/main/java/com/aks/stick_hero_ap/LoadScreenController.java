package com.aks.stick_hero_ap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class LoadScreenController extends GameController implements Initializable,Sound{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int score;
    private int cherry;
    private Player player;
    private MusicController musicController;

    Image image= new Image(getClass().getResourceAsStream("BG-Load.jpg"));

    @FXML
    ImageView backgroundImageView;

    double targetWidth=300;
    double targetHeight=500;

    double scaleFactor=targetWidth/ image.getWidth();

    //@FXML
    //AnchorPane pausePane;

//    @FXML
//    AnchorPane gamePane;

    //@FXML
    //Polygon resumeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //pausePane.setVisible(true);
        //gamePane.setVisible(false);
        initialiseSound(); //Setting up-Sound for this Scene

        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);

    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio(); // stopping audio before changing scene
        stage.show();
    }

    public void switchToSinglePlayerHomeScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerHomeScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicController.stopAudio(); // stopping audio before changing scene
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

    public Player getSaveGame(int serial){ // Pass values from 1-4
        Player player = null;
        ObjectInputStream in = null;
        String val = String.valueOf(serial);
        try{
            in = new ObjectInputStream(new FileInputStream(val+".txt"));
            player = (Player) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to Retrieve Save Game File due to: " + e.getMessage());
        }
        return player;
    }

    public void removeSaveGame(int serial){
        String saveFile = "Saves\\" + serial +".txt";
        Path savePath = Paths.get(saveFile);
        try{
            Files.deleteIfExists(savePath);
//            System.out.println("Save File for Slot" + serial + " Deleted Successfully");
        } catch (IOException e) {
            System.out.println("Unable to Delete Save Game due to: " + e.getMessage());
        }
    }

    @Override
    public void initialiseSound() {
        musicController = new MusicController(getClass().getResource("data.mp3").toExternalForm());
        muteUnmute();
    }

    public void muteUnmute() {
        if(AudioManager.isMuted()) { // if sound is muted
            musicController.stopAudio(); // stops the audio
        }
        else {
            musicController.playAudio(); //plays the audio
        }
    }
}

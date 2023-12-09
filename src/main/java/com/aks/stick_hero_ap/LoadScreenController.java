package com.aks.stick_hero_ap;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private MusicAdapter musicAdapter;
    private SinglePlayerGameScreenController singlePlayerGameScreenController;

    Image image= new Image(getClass().getResourceAsStream("BG-Load.jpg"));

    @FXML
    ImageView backgroundImageView;

    @FXML
    private ImageView playImageView1,playImageView2,playImageView3,playImageView4,removeImageView1,removeImageView2,removeImageView3,removeImageView4;

    @FXML
    private Label saveGameNotFoundLabel;

    @FXML
    private Rectangle saveGameLabelBackground;

    @FXML
    private AnchorPane loadScreenAnchorPane;

    private Player p1=null;

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    private boolean isLoaded=false;

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
        singlePlayerGameScreenController = new SinglePlayerGameScreenController();
        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);
        saveGameNotFoundLabel.setLayoutX(1000);
        saveGameLabelBackground.setLayoutX(1000);
        playImageView1.setOnMouseClicked(mouseEvent -> {
            try{
                p1 = getSaveGame(1);
                //data = getSaveGame2(1);
                if(p1 != null) { // If Save Game is Found then Load it into Player Object in Single Player Game Screen
                    isLoaded=true;
                    //ActionEvent event=new ActionEvent();
                    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
                    //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
                    Parent root=fxmlLoader.load();
                    SinglePlayerGameScreenController controller = fxmlLoader.getController();
                    controller.setCurrentScoreAndShow(p1.getCurrentScore());
                    controller.setCherriesAndShow(p1.getCherriesCollected());
                    controller.setPlayer1(p1);
                    controller.setLoaded(true);

                    stage=(Stage)loadScreenAnchorPane.getScene().getWindow();
                    scene=new Scene(root,300,500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    musicAdapter.muteSound(); // stopping audio before changing scene
                    stage.show();
                }
            }
            catch (Exception e){
                FadeTransition labelFadeTransition=new FadeTransition();
                labelFadeTransition.setNode(saveGameNotFoundLabel);
                labelFadeTransition.setDuration(Duration.seconds(1));
                labelFadeTransition.setCycleCount(1);
                labelFadeTransition.setAutoReverse(true);
                labelFadeTransition.setFromValue(0);
                labelFadeTransition.setToValue(1);
                labelFadeTransition.play();
            }
        });
        playImageView2.setOnMouseClicked(mouseEvent -> {
            p1 = getSaveGame(2);
            if(p1 != null) { // If Save Game is Found then Load it into Player Object in Single Player Game Screen
                isLoaded=true;
                //ActionEvent event=new ActionEvent();
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
                //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
                Parent root= null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                SinglePlayerGameScreenController controller = fxmlLoader.getController();
                controller.setCurrentScoreAndShow(p1.getCurrentScore());
                controller.setCherriesAndShow(p1.getCherriesCollected());
                controller.setPlayer1(p1);
                controller.setLoaded(true);

                stage=(Stage)loadScreenAnchorPane.getScene().getWindow();
                scene=new Scene(root,300,500);
                stage.setScene(scene);
                stage.setResizable(false);
                musicAdapter.muteSound(); // stopping audio before changing scene
                stage.show();
            }
        });
        playImageView3.setOnMouseClicked(mouseEvent -> {
            try{
                p1 = getSaveGame(3);
                if(p1 != null) { // If Save Game is Found then Load it into Player Object in Single Player Game Screen
                    isLoaded=true;
                    //ActionEvent event=new ActionEvent();
                    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
                    //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
                    Parent root=fxmlLoader.load();
                    SinglePlayerGameScreenController controller = fxmlLoader.getController();
                    controller.setCurrentScoreAndShow(p1.getCurrentScore());
                    controller.setCherriesAndShow(p1.getCherriesCollected());
                    controller.setPlayer1(p1);
                    controller.setLoaded(true);

                    stage=(Stage)loadScreenAnchorPane.getScene().getWindow();
                    scene=new Scene(root,300,500);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    musicAdapter.muteSound(); // stopping audio before changing scene
                    stage.show();
                }
            }
            catch (Exception e){
                FadeTransition labelFadeTransition=new FadeTransition();
                saveGameNotFoundLabel.setOpacity(1);
                labelFadeTransition.setNode(saveGameNotFoundLabel);
                labelFadeTransition.setDuration(Duration.seconds(1));
                labelFadeTransition.setCycleCount(1);
                labelFadeTransition.setAutoReverse(true);
                labelFadeTransition.setFromValue(0);
                labelFadeTransition.setToValue(1);
                labelFadeTransition.play();
            }
        });
        playImageView4.setOnMouseClicked(mouseEvent -> {
            p1 = getSaveGame(4);
            if(p1 != null) { // If Save Game is Found then Load it into Player Object in Single Player Game Screen
                isLoaded=true;
                //ActionEvent event=new ActionEvent();
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
                //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
                Parent root= null;
                try {
                    root = fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                SinglePlayerGameScreenController controller = fxmlLoader.getController();
                controller.setCurrentScoreAndShow(p1.getCurrentScore());
                controller.setCherriesAndShow(p1.getCherriesCollected());
                controller.setPlayer1(p1);
                controller.setLoaded(true);

                stage=(Stage)loadScreenAnchorPane.getScene().getWindow();
                scene=new Scene(root,300,500);
                stage.setScene(scene);
                stage.setResizable(false);
                musicAdapter.muteSound(); // stopping audio before changing scene
                stage.show();
            }
        });

        removeImageView1.setOnMouseClicked(mouseEvent -> {
            removeSaveGame(1);
        });
        removeImageView2.setOnMouseClicked(mouseEvent -> {
            removeSaveGame(2);
        });
        removeImageView3.setOnMouseClicked(mouseEvent -> {
            removeSaveGame(3);
        });
        removeImageView4.setOnMouseClicked(mouseEvent -> {
            removeSaveGame(4);
        });

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);

    }

    public void switchToSinglePlayerGameScreen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("SinglePlayerGameScreen.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerGameScreen.fxml"));
        Parent root=fxmlLoader.load();
        SinglePlayerGameScreenController controller = fxmlLoader.getController();
        if(isLoaded()){
            controller.setPlayer1(p1);
            controller.setLoaded(true);
        }
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // stopping audio before changing scene
        stage.show();
    }

    public void switchToSinglePlayerHomeScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("SinglePlayerHomeScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // stopping audio before changing scene
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
            in = new ObjectInputStream(new FileInputStream("Saves\\" + val + ".txt"));
            player = (Player) in.readObject();
            System.out.println("Got the save game boi");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to Retrieve Save Game File due to: " + e.getMessage());
            saveGameNotFoundLabel.setLayoutX(22);
            saveGameLabelBackground.setLayoutX(22);
            FadeTransition labelFadeTransition=new FadeTransition();
            FadeTransition backgroundFadeTransition=new FadeTransition();
            //saveGameNotFoundLabel.setOpacity(1);
            labelFadeTransition.setNode(saveGameNotFoundLabel);
            backgroundFadeTransition.setNode(saveGameLabelBackground);
            backgroundFadeTransition.setDuration(Duration.seconds(1));
            backgroundFadeTransition.setAutoReverse(true);
            backgroundFadeTransition.setCycleCount(2);
            backgroundFadeTransition.setFromValue(0);
            backgroundFadeTransition.setToValue(1);
            labelFadeTransition.setDuration(Duration.seconds(1));

            labelFadeTransition.setCycleCount(2);
            labelFadeTransition.setAutoReverse(true);
            labelFadeTransition.setFromValue(0);
            labelFadeTransition.setToValue(1);
            labelFadeTransition.setOnFinished(event -> {
                System.out.println("After Fade Transition");
                saveGameNotFoundLabel.setLayoutX(1000);
            });
            backgroundFadeTransition.setOnFinished(actionEvent -> {
                saveGameLabelBackground.setLayoutX(1000);
            });

            System.out.println("Before Fade Transition");
            labelFadeTransition.play();
            backgroundFadeTransition.play();
        }
        return player;
    }

    public void removeSaveGame(int serial){
        String saveFile = "Saves\\" + serial +".txt";
        Path savePath = Paths.get(saveFile);
        try{
            Files.deleteIfExists(savePath);
            System.out.println("Save File for Slot" + serial + " Deleted Successfully");
        } catch (IOException e) {
            System.out.println("Unable to Delete Save Game due to: " + e.getMessage());

        }
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

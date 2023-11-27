package com.aks.stick_hero_ap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SaveScreenController extends PauseController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int score;
    private int cherry;

    Image image= new Image(getClass().getResourceAsStream("BG-Save.jpg"));

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

        backgroundImageView.setImage(image);

        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);

//        BoxBlur blur=new BoxBlur(10,10,3);
//        gamePane.setEffect(blur);


    }

    public void switchToPauseMenuScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("PauseMenuScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

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
}

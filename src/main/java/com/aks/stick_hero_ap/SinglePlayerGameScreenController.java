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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerGameScreenController extends SinglePlayerMode implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Rectangle platform1,platform2;

    int platformHeight=200;

    double platform1Width=100,platform1PositionX=0,platform1PositionY=300;

    Platform platform1Details=new Platform(100,platformHeight,0,300);

    Platform platform2Details=new Platform(100,platformHeight,1000,1000);

    double platform2Width=200,platform2PositionX=1000,platform2PositionY=1000;

    //@FXML
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

    @FXML
    private AnchorPane gameCharacterPane;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //pausePane.setVisible(true);
        //gamePane.setVisible(false);

        backgroundImageView.setImage(image);

        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);
        //root.getChildrenUnmodifiable().add(platform1);

        platform1.setOpacity(1);
        platform2.setOpacity(1);
        platform2.setWidth(platform2Details.getWidth());
        platform2.setHeight(platformHeight);
        platform2.setX(platform2Details.getPositionX());
        platform2.setY(platform2Details.getPositionY());
        platform1.setHeight(platformHeight);
        platform1.setWidth(platform1Details.getWidth());
        platform1.setLayoutX(platform1Details.getPositionX());
        platform1.setLayoutY(platform1Details.getPositionY());
        //System.out.println(platform1.getY());
        gameCharacterPane.setPrefWidth(10);
        gameCharacterPane.setPrefHeight(10);
        gameCharacterPane.setLayoutX(50);




    }

    public void getTheRootFromPreviousScene(Parent root){
        this.root=root;
    }


    public void switchToPauseMenuScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("PauseMenuScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void switchToGameOverScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("GameOverScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}

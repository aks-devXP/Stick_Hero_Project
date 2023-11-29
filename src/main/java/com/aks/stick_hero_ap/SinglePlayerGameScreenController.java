package com.aks.stick_hero_ap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerGameScreenController extends SinglePlayerMode implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Line line=new Line();

    @FXML
    private Button fullScreenLineExtensionButton;

    private double startPoleX, startPoleY, endPoleX, endPoleY;

    private boolean clickHeld=false,clickReleased=false;

    @FXML
    Rectangle platform1,platform2;

    int platformHeight=150;

    //double platform1Width=100,platform1PositionX=0,platform1PositionY=300;

    Platform platform1Details=new Platform(60,platformHeight,0,350);

    Platform platform2Details=new Platform(80,platformHeight,1000,1000);

    Platform currentPlatformDetails;

    private int activePlatform=1; //This is used to check which platform the player is standing on,
                                  //then it is also used to check the alignment of the pole with the platform.

    //double platform2Width=200,platform2PositionX=1000,platform2PositionY=1000;

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

    Timeline timeline;




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
        currentPlatformDetails=platform1Details;
        //System.out.println(platform1.getY());
        gameCharacterPane.setPrefWidth(0);
        gameCharacterPane.setPrefHeight(0);
        gameCharacterPane.setLayoutX(40);    //-10 as 10 is the width of the character
        gameCharacterPane.setLayoutY(330);   //-20 as 20 is the height of the character

        startPoleX=currentPlatformDetails.getPositionX()+currentPlatformDetails.getWidth();
        startPoleY=currentPlatformDetails.getPositionY();
        endPoleX=startPoleX;
        endPoleY=startPoleY;
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
        line.setStrokeWidth(5);
        gamePane.getChildren().add(line);

        fullScreenLineExtensionButton.setOnMousePressed(event -> {
            clickHeld=true;
            if(!clickReleased){
                poleExtendingTrue();
            }


        });
        fullScreenLineExtensionButton.setOnMouseReleased(event -> {
            poleExtendingFalse();
        });




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




    public void poleExtendingTrue(){

        timeline=new Timeline(new KeyFrame(Duration.millis(50),event -> {
            if(clickHeld){
                endPoleY-=4;
                drawLine();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void poleExtendingFalse(){
        clickHeld=false;
        clickReleased=true;
        timeline.stop();

    }
    private void drawLine() {
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
    }





}

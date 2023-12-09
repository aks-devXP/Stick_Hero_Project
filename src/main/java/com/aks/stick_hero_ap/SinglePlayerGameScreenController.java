package com.aks.stick_hero_ap;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class SinglePlayerGameScreenController extends GameController implements Initializable,Sound {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Line line = new Line();
    private RotateTransition rotatePole;

    private Timeline rotateTimeline;

    private Rotate lineRotation;
    private MusicController musicController;
    private MusicAdapter musicAdapter;
    private static Player player1;

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        SinglePlayerGameScreenController.player1 = player1;
    }

    @FXML
    private Button fullScreenLineExtensionButton;

    private double startPoleX, startPoleY, endPoleX, endPoleY, poleLength=0;

    private boolean clickHeld=false,clickReleased=false, poleRotated=false, characterFlipped=false,cherryUpdated=false;

    private boolean gameOver=false; //This gameOver will be used in movingCharacter function
    private boolean Loaded;

    @FXML
    Rectangle platform1,platform2;

    Rectangle currentPlatform;

    int currentPlatformNumber=0;

    int platformHeight=150;
    double gap=25;

    //double platform1Width=100,platform1PositionX=0,platform1PositionY=300;

    Platform platform1Details=new Platform(60,platformHeight,0,350);

    Platform platform2Details=new Platform(80,platformHeight,70,350);

    Platform currentPlatformDetails;

    double nextPlatformWidth,nextPlatformPosition;

    private int activePlatform = 1; //This is used to check which platform the player is standing on,
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

    @FXML
    private Label currentScoreLabel,cheeryLabel;

    @FXML
    private ImageView cherryImageView;

    @FXML
    private Button restartButton;

    double cherryPosition;

    int numCherry=0;

    private int currentScore=0;

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    private int bestScore=0;

    Timeline timeline;
    int numRun=1;

    public boolean isLoaded() {
        return Loaded;
    }

    public void setLoaded(boolean loaded) {
        Loaded = loaded;
    }

    public static Player getPlayerInstance1(){
        if(getPlayer1() == null){
            setPlayer1(new Player());
        }
        return getPlayer1();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //pausePane.setVisible(true);
        //gamePane.setVisible(false);
        initialiseSound(); // Setting up Sound
        if(!isLoaded()) {
            //setPlayer1(new Player());
            getPlayerInstance1();
        };
        //gameOverScreenAnchorPane.setLayoutX(-1000);
        //gameOverScreenAnchorPane.
        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);
        //root.getChildrenUnmodifiable().add(platform1);
        //currentScore=0;
        currentScoreLabel.setText(Integer.toString(currentScore));


        platform1.setOpacity(1);
        platform1.setHeight(platformHeight);
        platform1.setWidth(platform1Details.getWidth());
        platform1.setLayoutX(platform1Details.getPositionX());
        platform1.setLayoutY(platform1Details.getPositionY());
        currentPlatformDetails=platform1Details;
        currentPlatform=platform1;

        currentPlatformNumber=1;
        nextPlatformWidth= randomWidth(currentPlatformDetails.getWidth(),gap);
        nextPlatformPosition=randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);
        platform2.setOpacity(1);
        platform2.setWidth(nextPlatformWidth);
        platform2.setHeight(platformHeight);
        platform2.setLayoutX(nextPlatformPosition);
        platform2.setLayoutY(platform2Details.getPositionY());

        //System.out.println(platform1.getY());
        gameCharacterPane.setPrefWidth(0);
        gameCharacterPane.setPrefHeight(0);
        gameCharacterPane.setLayoutX(35);    //-15 as 10 is the width of the character + 5 for proper gap between stick and player
        gameCharacterPane.setLayoutY(330);   //-20 as 20 is the height of the character
        cherryImageView.setLayoutY(350);
        cherryPosition=randomCherryX(currentPlatform.getWidth(),platform2.getLayoutX());
        cherryImageView.setLayoutX(cherryPosition);
        cheeryLabel.setText(String.valueOf(numCherry));

        startPoleX=currentPlatformDetails.getPositionX()+currentPlatformDetails.getWidth();
        startPoleY=currentPlatformDetails.getPositionY();
        endPoleX=startPoleX;
        endPoleY=startPoleY;
        poleLength=0;
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
        line.setStrokeWidth(5);
        gamePane.getChildren().add(line);

        System.out.println("pane length "+gameCharacterPane.getWidth());

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
        musicAdapter.muteSound(); // stopping audio before changing scene
        stage.show();
    }


    public void switchToGameOverScreen(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("GameOverScreen.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // stopping audio before changing scene
        stage.show();
    }

    public void poleExtendingTrue(){

        timeline=new Timeline(new KeyFrame(Duration.millis(50),event -> {
            if(clickHeld){
                endPoleY-=4;
                poleLength+=4;
                drawLine();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);

        timeline.play();
    }

    public void setCurrentScoreAndShow(int num){
        setCurrentScore(num);
        currentScoreLabel.setText(String.valueOf(num));
    }

    public void setCherriesAndShow(int cherries){
        setCherriesCollected(cherries);
        cheeryLabel.setText(String.valueOf(cherries));
    }

    public void poleExtendingFalse(){
        clickHeld=false;
        clickReleased=true;
        timeline.stop();

        if(!poleRotated){
            poleRotated=true;
            startRotatingPole();
        }

        //rotateTimeline.stop();

        //rotateTimeline.stop();
        //poleFallingAnimation();


    }
    private void drawLine() {
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
    }

    public void startRotatingPole(){

        lineRotation = new Rotate();
        lineRotation.pivotXProperty().bind(line.startXProperty());
        lineRotation.pivotYProperty().bind(line.startYProperty());

        line.getTransforms().add(lineRotation);

        rotateTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(lineRotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(lineRotation.angleProperty(), 90)));

        rotateTimeline.play();
        rotateTimeline.setOnFinished(event -> {stopRotatingPole();});


    }
    public void stopRotatingPole(){
        rotateTimeline.stop();
        characterFlipped=false;
        if(currentPlatformNumber==1){
//            currentPlatformNumber=2;
//            currentPlatform=platform2;
            movingCharacter(poleLength,platform1,platform2);

            //moveCharacterAndPlatformToStart(platform1,platform2);
        }else{
//            currentPlatformNumber=1;
//            currentPlatform=platform1;
            movingCharacter(poleLength,platform2,platform1);

            //moveCharacterAndPlatformToStart(platform2,platform1);
        }
    }


    public void movingCharacter(double lineLength,Rectangle currentPlatform,Rectangle nextPlatform){
        Timeline characterTranslateTimeline=new Timeline();
        KeyFrame characterEnd = null;

        double currentCharacterPosition=gameCharacterPane.getLayoutX();
        if(startPoleX+lineLength<nextPlatform.getLayoutX()||startPoleX+lineLength>nextPlatform.getLayoutX()+nextPlatform.getWidth()){
            characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength));
            gameOver=true;
        }

        else if(startPoleX+lineLength>=nextPlatform.getLayoutX()&&startPoleX+lineLength<=nextPlatform.getLayoutX()+nextPlatform.getWidth()){
            if(startPoleX+lineLength-nextPlatform.getLayoutX()>20 && startPoleX+lineLength-nextPlatform.getLayoutX()<=30){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-20));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>30 && startPoleX+lineLength-nextPlatform.getLayoutX()<=40){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-30));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>40 && startPoleX+lineLength-nextPlatform.getLayoutX()<=50){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-40));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>50 && startPoleX+lineLength-nextPlatform.getLayoutX()<=60){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-50));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>60 && startPoleX+lineLength-nextPlatform.getLayoutX()<=70){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-60));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>70 && startPoleX+lineLength-nextPlatform.getLayoutX()<=80){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-70));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>80 && startPoleX+lineLength-nextPlatform.getLayoutX()<=90){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-80));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>90 && startPoleX+lineLength-nextPlatform.getLayoutX()<=100){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-90));
            }
            else if(startPoleX+lineLength-nextPlatform.getLayoutX()>100){
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength-100));
            }
            else{
                characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength));
            }

//            if(numRun==1||nextPlatform.getLayoutX()-currentPlatform.getWidth()<85){
//                characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+nextPlatform.getLayoutX()-50));
//            }
//            else{
//                characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+nextPlatform.getLayoutX()-85));
//            }
            gameOver=false;
            //characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),currentCharacterPosition+nextPlatform.getLayoutX()+nextPlatform.getWidth()-100));
            //gameOver=false;

        }
//        if(characterFlipped && (gameCharacterPane.getLayoutX()+15)>=nextPlatform.getLayoutX()){
//            gameOver=true;
//            characterFall();
//            return;
//        }

        fullScreenLineExtensionButton.setOnMouseClicked(mouseEvent -> {
            double rectangleHeight = 20;
            if(!characterFlipped){
                if((gameCharacterPane.getLayoutX()>=currentPlatform.getWidth()-15)&& gameCharacterPane.getLayoutX()<nextPlatform.getLayoutX()){

                    characterFlipped=true;
//                    if(characterFlipped && (gameCharacterPane.getLayoutX()+15)>=nextPlatform.getLayoutX()){
//                        gameOver=true;
//
//                    }
                    gameCharacterPane.setRotationAxis(new Point3D(1,0,0));
                    gameCharacterPane.setRotate(180);
                    gameCharacterPane.setLayoutY(gameCharacterPane.getLayoutY()+2*rectangleHeight);
                }
            }

            else{
                if((gameCharacterPane.getLayoutX()>=currentPlatform.getWidth()-15)&& gameCharacterPane.getLayoutX()<nextPlatform.getLayoutX()){
                    characterFlipped=false;
                    gameCharacterPane.setRotationAxis(new Point3D(1,0,0));
                    gameCharacterPane.setRotate(0);
                    gameCharacterPane.setLayoutY(gameCharacterPane.getLayoutY()-2*rectangleHeight);
                }
//                else if(gameCharacterPane.getLayoutX()>=nextPlatform.getLayoutX()){
//                    gameOver=true;
//
//                }

            }

        });

        characterTranslateTimeline.getKeyFrames().add(characterEnd);
        gameCharacterPane.layoutXProperty().addListener((obs, oldVal, newVal) -> {
            double characterXPosition = newVal.doubleValue();
            System.out.println("Current platform "+currentPlatformNumber);
            System.out.println("Character: "+gameCharacterPane.getLayoutX());
            System.out.println("platform: "+nextPlatform.getLayoutX());
            if(characterFlipped && (characterXPosition>=cherryPosition && characterXPosition<=(cherryPosition+23))){
                if(!cherryUpdated){
                    if(isLoaded()) numCherry = getPlayer1().getCherriesCollected()+1;
                    else numCherry++;
                    getPlayer1().setCherriesCollected(getCherriesCollected()+1);
                    //setCherriesCollected(getPlayer1().getCherriesCollected()+1);
                    cherryUpdated=true;
                }
                cherryImageView.setOpacity(0);
                cheeryLabel.setText(String.valueOf(numCherry));
            }
            // Add your logic based on character's X position during animation here
//            if (characterFlipped && (characterXPosition+15) >= nextPlatform.getLayoutX()) {
//                gameOver = true;
//                characterFall();
//            }
        });
        characterTranslateTimeline.play();

        characterTranslateTimeline.setOnFinished(event -> {
            //fullScreenLineExtensionButton.setDisable(true);

//            if(characterFlipped){
//                characterFall();
//            }

            if(currentPlatformNumber==1){
                currentPlatformNumber=2;
                this.currentPlatform=platform2;
            }
            else{
                currentPlatformNumber=1;
                this.currentPlatform=platform1;
            }
            System.out.println(gameCharacterPane.getLayoutX());
            if(gameOver==true||characterFlipped){
                characterFall();
            }
            else{
                moveCharacterAndPlatformToStart(currentPlatform,nextPlatform);
            }

        });


    }


    public void moveCharacterAndPlatformToStart(Rectangle previousPlatform,Rectangle currentPlatform){
        cherryImageView.setOpacity(0);
        line.setOpacity(0);
        if(isLoaded()){
            currentScore = (getPlayer1().getCurrentScore()+1);

        }
        else currentScore++;
        getPlayer1().setCurrentScore(getCurrentScore()+1);

        if(getBestScore()<currentScore){
            setBestScore(currentScore);
        }
        Timeline previousPlatformTimeline = new Timeline();
        KeyFrame previousPlatformEnd = new KeyFrame(Duration.millis(1000), new KeyValue(previousPlatform.layoutXProperty(), -1000));
        previousPlatformTimeline.getKeyFrames().add(previousPlatformEnd);
        previousPlatformTimeline.play();
        currentScoreLabel.setText(Integer.toString(currentScore));
        previousPlatformTimeline.setOnFinished(event -> {
            System.out.println("previousPlatform="+previousPlatform.getLayoutX());
        });


        Timeline characterTimeline=new Timeline();
        System.out.println(gameCharacterPane.getLayoutX());


        if(currentPlatform.getWidth()>100){

            Timeline timeline = new Timeline();
            KeyFrame end = new KeyFrame(Duration.millis(1000), new KeyValue(currentPlatform.layoutXProperty(), 0-(currentPlatform.getWidth()-100)));
            KeyFrame characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),(100-25)));
            characterTimeline.getKeyFrames().add(characterEnd);
            characterTimeline.play();
            timeline.getKeyFrames().add(end);
            timeline.play();
            //characterTranslate.play();
            timeline.setOnFinished(event -> {
                System.out.println(currentPlatform.getLayoutX());
                currentPlatform.setWidth(100);
                currentPlatform.setLayoutX(0);
                gameCharacterPane.setLayoutX(currentPlatform.getWidth()-25);
                initEverything();
                //System.out.println(currentPlatform.getWidth()+"+"+currentPlatform.getLayoutX());
            });
        }
        else{
            //characterTranslate.setByX(-1*(300-(300-currentPlatform.getLayoutX())));
            Timeline timeline = new Timeline();
            KeyFrame end = new KeyFrame(Duration.millis(1000), new KeyValue(currentPlatform.layoutXProperty(), 0));
            KeyFrame characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),(currentPlatform.getWidth()-25)));
            characterTimeline.getKeyFrames().add(characterEnd);
            characterTimeline.play();
            timeline.getKeyFrames().add(end);
            timeline.play();
            //characterTranslate.play();
            timeline.setOnFinished(event -> {
                System.out.println(currentPlatform.getLayoutX());
                currentPlatform.setWidth(currentPlatform.getWidth());
                currentPlatform.setLayoutX(0);
                gameCharacterPane.setLayoutX(currentPlatform.getWidth()-25);
                initEverything();
            });
        }



        //currentPlatformTranslate.play();

        //currentPlatformTranslate.setByX(-1*(300-currentPlatform.getWidth()-2*gap-30));


    }

    public void characterFall(){
        Timeline characterFallTimeline=new Timeline();
        KeyFrame characterFallEnd=new KeyFrame(Duration.millis(250),new KeyValue(gameCharacterPane.layoutYProperty(),800));
        characterFallTimeline.getKeyFrames().add(characterFallEnd);
        characterFallTimeline.play();
        characterFallTimeline.setOnFinished(actionEvent -> {
            //gameOverScreenAnchorPane.setLayoutX(0);

            try {
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("GameOverScreen.fxml"));
                //Parent root = FXMLLoader.load(getClass().getResource("GameOverScreen.fxml"));
                Parent root=fxmlLoader.load();
                GameOverController gameController=fxmlLoader.getController();
                //gameController.setNumberOfCherries(numCherry);
                gameController.setCurrentScoreLabel(currentScore);
                gameController.setCherries(numCherry);
                gameController.setBestScore(getBestScore());
                System.out.println(gameController.getScore());
                Stage stage = (Stage) gameCharacterPane.getScene().getWindow(); // Or line.getScene().getWindow()
                Scene scene = new Scene(root, 300, 500);

                stage.setScene(scene);
                stage.setResizable(false);
                musicAdapter.muteSound(); // Stopping audio before changing scene
                stage.show();
                line.setOpacity(0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public void initEverything(){
        numRun++;
        startPoleX=currentPlatform.getLayoutX()+currentPlatform.getWidth();
        startPoleY=currentPlatform.getLayoutY();
        endPoleX=startPoleX;
        endPoleY=startPoleY;

        poleLength=0;
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
        line.getTransforms().remove(lineRotation);
        line.setRotate(0);
        line.setOpacity(1);
        cherryUpdated=false;
        if(currentPlatformNumber==1){
            //currentPlatform=platform1;
            nextPlatformWidth= randomWidth(currentPlatform.getWidth(),gap);
            nextPlatformPosition=randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);
            platform2.setOpacity(1);
            platform2.setWidth(nextPlatformWidth);
            platform2.setHeight(platformHeight);
            platform2.setLayoutX(nextPlatformPosition);
            platform2.setLayoutY(platform2Details.getPositionY());
            cherryImageView.setOpacity(1);
            cherryImageView.setLayoutY(350);
            cherryPosition=randomCherryX(platform1.getWidth(),platform2.getLayoutX());
            cherryImageView.setLayoutX(cherryPosition);

        }
        else{
            //currentPlatform=platform2;
            nextPlatformWidth= randomWidth(currentPlatform.getWidth(),gap);
            nextPlatformPosition=randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);

            platform1.setOpacity(1);
            platform1.setWidth(nextPlatformWidth);
            platform1.setHeight(platformHeight);
            platform1.setLayoutX(nextPlatformPosition);
            platform1.setLayoutY(platform1Details.getPositionY());
            cherryImageView.setOpacity(1);
            cherryImageView.setLayoutY(350);
            cherryPosition=randomCherryX(platform2.getWidth(),platform1.getLayoutX());
            cherryImageView.setLayoutX(cherryPosition);
        }

        fullScreenLineExtensionButton.setOnMousePressed(event -> {
            clickHeld=true;
            if(!clickReleased){
                poleExtendingTrue();
            }

        });
        fullScreenLineExtensionButton.setOnMouseReleased(event -> {
            poleExtendingFalse();

        });

        clickHeld=false;
        clickReleased=false;
        poleRotated=false;
        gameOver=false;

    }


    public void setNumCherryAndLabel(int numCherry){
        this.numCherry=numCherry;
        cheeryLabel.setText(String.valueOf(numCherry));
    }
    public void setCurrentScoreAndLabel(int currentScore){
        this.currentScore=currentScore;
        currentScoreLabel.setText(String.valueOf(currentScore));
    }

    public void setMusicAdapter(){
        this.musicAdapter = new MusicAdapter(this.musicController,"game1.mp3");
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

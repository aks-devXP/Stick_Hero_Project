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

/*
This class basically handles all of the functions for the singleplayergamescreen, it is the controller for the single player game screen
 */

public class SinglePlayerGameScreenController  implements Initializable,Sound {

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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

    private Stage stage;
    private Scene scene;
    private Parent root;

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Timeline getRotateTimeline() {
        return rotateTimeline;
    }

    public void setRotateTimeline(Timeline rotateTimeline) {
        this.rotateTimeline = rotateTimeline;
    }

    public Rotate getLineRotation() {
        return lineRotation;
    }

    public void setLineRotation(Rotate lineRotation) {
        this.lineRotation = lineRotation;
    }

    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
    }

    public MusicAdapter getMusicAdapter() {
        return musicAdapter;
    }

    public void setMusicAdapter(MusicAdapter musicAdapter) {
        this.musicAdapter = musicAdapter;
    }

    public Button getFullScreenLineExtensionButton() {
        return fullScreenLineExtensionButton;
    }

    public void setFullScreenLineExtensionButton(Button fullScreenLineExtensionButton) {
        this.fullScreenLineExtensionButton = fullScreenLineExtensionButton;
    }

    public double getStartPoleX() {
        return startPoleX;
    }

    public void setStartPoleX(double startPoleX) {
        this.startPoleX = startPoleX;
    }

    public double getStartPoleY() {
        return startPoleY;
    }

    public void setStartPoleY(double startPoleY) {
        this.startPoleY = startPoleY;
    }

    public double getEndPoleX() {
        return endPoleX;
    }

    public void setEndPoleX(double endPoleX) {
        this.endPoleX = endPoleX;
    }

    public double getEndPoleY() {
        return endPoleY;
    }

    public void setEndPoleY(double endPoleY) {
        this.endPoleY = endPoleY;
    }


    public void setPoleLength(double poleLength) {
        this.poleLength = poleLength;
    }

    public boolean isClickHeld() {
        return clickHeld;
    }

    public void setClickHeld(boolean clickHeld) {
        this.clickHeld = clickHeld;
    }

    public boolean isClickReleased() {
        return clickReleased;
    }

    public void setClickReleased(boolean clickReleased) {
        this.clickReleased = clickReleased;
    }

    public boolean isPoleRotated() {
        return poleRotated;
    }

    public void setPoleRotated(boolean poleRotated) {
        this.poleRotated = poleRotated;
    }

    public boolean isCharacterFlipped() {
        return characterFlipped;
    }

    public void setCharacterFlipped(boolean characterFlipped) {
        this.characterFlipped = characterFlipped;
    }

    public boolean isCherryUpdated() {
        return cherryUpdated;
    }

    public void setCherryUpdated(boolean cherryUpdated) {
        this.cherryUpdated = cherryUpdated;
    }

    public boolean isWasPaused() {
        return wasPaused;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getActivePlatform() {
        return activePlatform;
    }

    public void setActivePlatform(int activePlatform) {
        this.activePlatform = activePlatform;
    }

    public AnchorPane getGameCharacterPane() {
        return gameCharacterPane;
    }

    public void setGameCharacterPane(AnchorPane gameCharacterPane) {
        this.gameCharacterPane = gameCharacterPane;
    }

    public Label getCurrentScoreLabel() {
        return currentScoreLabel;
    }

    public void setCurrentScoreLabel(Label currentScoreLabel) {
        this.currentScoreLabel = currentScoreLabel;
    }

    public Label getCheeryLabel() {
        return cheeryLabel;
    }

    public void setCheeryLabel(Label cheeryLabel) {
        this.cheeryLabel = cheeryLabel;
    }

    public ImageView getCherryImageView() {
        return cherryImageView;
    }

    public void setCherryImageView(ImageView cherryImageView) {
        this.cherryImageView = cherryImageView;
    }

    public Button getRestartButton() {
        return restartButton;
    }

    public void setRestartButton(Button restartButton) {
        this.restartButton = restartButton;
    }

    public Button getPauseButton() {
        return pauseButton;
    }

    public void setPauseButton(Button pauseButton) {
        this.pauseButton = pauseButton;
    }

//    @Override
//    public int getCurrentScore() {
//        return currentScore;
//    }
//
//    @Override
//    public void setCurrentScore(int currentScore) {
//        this.currentScore = currentScore;
//    }

    private Line line = new Line();   //This line is the pole that extends and then drops

    private Timeline rotateTimeline;   //This is the timeline function for the animation of the rotation of the pole.

    private Rotate lineRotation;   //This will be used along with the rotateTimeline function to animate the rotation of the pole falling.
    private MusicController musicController;  //THis is for controlling the music playing in the background.
    private MusicAdapter musicAdapter;
    private static Player player1;  //From the player class, it is used to keep track of the details of the player and uses singleton design pattern

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        SinglePlayerGameScreenController.player1 = player1;
    }

    @FXML
    private Button fullScreenLineExtensionButton;         //This is the button variable for extending the pole and character flipping.

    private double startPoleX, startPoleY, endPoleX, endPoleY, poleLength=0;   //For the length of the pole and the position of the pole


    /*
    These are different boolean variables for checking different things and conditions.
     */
    private boolean clickHeld=false;
    private boolean clickReleased=false;
    private boolean poleRotated=false;
    private boolean characterFlipped=false;
    private boolean cherryUpdated=false;

    public boolean getWasPaused() {
        return wasPaused;
    }

    public void setWasPaused(boolean wasPaused) {
        this.wasPaused = wasPaused;
    }

    private boolean wasPaused=false;

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
    private Button restartButton,pauseButton;

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

    public static Player getPlayerInstance1(){ //Singleton Design Pattern
        if(getPlayer1() == null){
            setPlayer1(Player.getPlayerInstance());
        }
        return getPlayer1();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        This function initialises everything including the background Image, the current score,
        the number of cherries, the current platform, the next platform, the position and the width
        of the next platform and the position of the player and also the pole.
         */
        initialiseSound(); // Setting up Sound
        if(!isLoaded() || !wasPaused) {
            //setPlayer1(new Player());
            getPlayerInstance1();
        };

        backgroundImageView.setImage(image);
        backgroundImageView.setFitWidth(targetWidth);
        backgroundImageView.setFitHeight(targetHeight);
        backgroundImageView.setPreserveRatio(false);

        currentScoreLabel.setText(Integer.toString(currentScore));

        platform1.setOpacity(1);
        platform1.setHeight(platformHeight);
        platform1.setWidth(platform1Details.getWidth());
        platform1.setLayoutX(platform1Details.getPositionX());
        platform1.setLayoutY(platform1Details.getPositionY());
        //System.out.println("VAL -> " + platform1Details.getPlayerInstance().getPositionY());
        currentPlatformDetails=platform1Details;
        currentPlatform=platform1;

        currentPlatformNumber=1;
        nextPlatformWidth= player1.randomWidth(currentPlatformDetails.getWidth(),gap);
        nextPlatformPosition= player1.randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);
        platform2.setOpacity(1);
        platform2.setWidth(nextPlatformWidth);
        platform2.setHeight(platformHeight);
        platform2.setLayoutX(nextPlatformPosition);
        platform2.setLayoutY(platform2Details.getPositionY());


        gameCharacterPane.setPrefWidth(0);
        gameCharacterPane.setPrefHeight(0);
        gameCharacterPane.setLayoutX(35);    //-15 as 10 is the width of the character + 5 for proper gap between stick and player
        gameCharacterPane.setLayoutY(330);   //-20 as 20 is the height of the character
        cherryImageView.setLayoutY(350);
        cherryPosition = player1.randomCherryX(currentPlatform.getWidth(),platform2.getLayoutX());
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


    //This function is used to communicate between the controllers when switching the scene.
    public void getTheRootFromPreviousScene(Parent root){
        this.root=root;
    }


    public void switchToPauseMenuScreen(ActionEvent event) throws IOException {
        /*
        This function is to switch the scene to the pause menu screen when the player presses the pause button.
        It uses FXMLLoader to get the PauseMenuScreen.fxml and then uses it to get the controller of the
        pause menu screen. It then uses it to communicate to the pause menu screen controller and then sets the cherries
        and the current score for the pause menu screen. This is done so that on un-pausing the player can start from right where
        he was.
         */
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("PauseMenuScreen.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("PauseMenuScreen.fxml"));
        Parent root=fxmlLoader.load();
        PauseController pauseController=fxmlLoader.getController();
        pauseController.setCurrentScore(currentScore);
        pauseController.setCherries(numCherry);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,300,500);
        stage.setScene(scene);
        stage.setResizable(false);
        musicAdapter.muteSound(); // stopping audio before changing scene
        stage.show();
    }




    public void poleExtendingTrue(){
        /*
        This function is used for extending the pole. This function uses the timeline and a keyfram to increase
        the lenght of the pole every 50 milliseconds and then draw it again while the click is pressed.
         */
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
        /*
        THis function is used to communicate between controllers and set the current score when we switch
        back to the single player game screen from some other screen.
         */
        this.currentScore=num;
        currentScoreLabel.setText(String.valueOf(num));
    }

    public void setCherriesAndShow(int cherries){
        /*
        THis function is used to communicate between controllers and set the number of cherries when we switch
        back to the single player game screen from some other screen.
         */
        this.numCherry=cherries;
        cheeryLabel.setText(String.valueOf(cherries));
    }

    public void poleExtendingFalse(){
        /*
        This function is to stop extending the pole when the click is released.
        It does so by setting clickHeld to false and clickReleased to true and then it calls
        the startRotatingPole() to start the pole rotation.
         */
        clickHeld=false;
        clickReleased=true;
        timeline.stop();

        if(!poleRotated){
            poleRotated=true;
            startRotatingPole();
        }

    }
    private void drawLine() {
        /*
        This functions draws the line as it is being extended.
        This is used for the animation of the pole extending.
         */
        line.setStartX(startPoleX);
        line.setStartY(startPoleY);
        line.setEndX(endPoleX);
        line.setEndY(endPoleY);
    }

    public void startRotatingPole(){
        /*
        This function rotated the pole when it stops extending.
        it uses a Rotate type object and binds the pivotXProperty and the
        pivotYProperty to the startXProperty and startYProperty of the pole(line)
         */
        lineRotation = new Rotate();
        lineRotation.pivotXProperty().bind(line.startXProperty());
        lineRotation.pivotYProperty().bind(line.startYProperty());

        //Then it adds this Rotate object to the transformations of the pole(line)
        line.getTransforms().add(lineRotation);

        /*
        This rotateTimeline function rotates the pole using the lineRotation Rotate type object.
        It rotates the pole to 90 degrees in a span of 1 seconds along the pivot.
         */
        rotateTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(lineRotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(lineRotation.angleProperty(), 90)));

        rotateTimeline.play();

        //On finishing the rotation, it calls the stopRotatingPole function to stop the pole rotation and
        //call other functions next.
        rotateTimeline.setOnFinished(event -> {stopRotatingPole();});


    }
    public void stopRotatingPole(){
        /*
        In this function first the rotate timeline is stopped and then the
        characterFlipped boolean variable is set to false.
         */
        rotateTimeline.stop();
        characterFlipped=false;

        /*
        Then the movingCharacter function is called according to which platform is currently the
        current platform and which is currently the next platform.
         */
        /*
        During the Animation of the character moving on the line
        the pauseButton is disabled so that the player cannot pause while the
        character is moving, this is done so that the code does not get too complicated.
         */
        pauseButton.setDisable(true);
        if(currentPlatformNumber==1){
            movingCharacter(poleLength,platform1,platform2);

        }else{

            movingCharacter(poleLength,platform2,platform1);
        }


    }

    /*
        This function is used to move the character along the line, from the current platform to the next platform
         */
    public void movingCharacter(double lineLength,Rectangle currentPlatform,Rectangle nextPlatform){

        /*
        This has a character translate timeline for movement of the character.
        This timeline uses the characterEnd keyframe to define the keyframes during the animation.
         */
        Timeline characterTranslateTimeline=new Timeline();
        KeyFrame characterEnd = null;

        /*
        This function basically sets the end point of the character animation.
        If the pole length is greater than the width of the next platform or lesser than the starting position of the next platform
        then it moves the character along the whole length of the line.
         */
        if(startPoleX+lineLength<nextPlatform.getLayoutX()||startPoleX+lineLength>nextPlatform.getLayoutX()+nextPlatform.getWidth()){
            characterEnd=new KeyFrame(Duration.millis(900),new KeyValue(gameCharacterPane.layoutXProperty(),gameCharacterPane.getLayoutX()+lineLength));
            gameOver=true;
        }

        /*
        This function basically sets the end point of the character animation.
        If the pole length endpoint is between the width of the next platform
        then it moves the character along the whole length of the line.
        It checks different conditions to set the endpoint of the animation of the character to be just to the start of the
        next platform. This is done so that it can be checked if the character is flipped or not and the game can end
        or continue accordingly.
         */
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

            //At the end of this function the gameOver variable is set to false as the game will not get over immediately if pole end lies on the platform.
            gameOver=false;


        }

        /*
        After the extension of the pole and the animation of the pole rotation,
         the full screen line extension button is set to flip the character on clicking.
         It first checks if the character is flipped or not then it accordingly flips
         the character in the oppossite direction.
         */
        fullScreenLineExtensionButton.setOnMouseClicked(mouseEvent -> {
            double rectangleHeight = 20;
            if(!characterFlipped){
                if((gameCharacterPane.getLayoutX()>=currentPlatform.getWidth()-15)&& gameCharacterPane.getLayoutX()<nextPlatform.getLayoutX()){

                    characterFlipped=true;

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


            }

        });

        /*
        Then it adds the characterEnd keyframe to the characterTranslateTimeline.
        it then uses the function addListener to check the current horizontal position of the character
        , this is done so that the characters current position can be checked relative to the current position
        of the cherry so that the character can pick up the cherry.
         */
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
                    getPlayer1().setCherriesCollected(getPlayer1().getCherriesCollected()+1);
                    cherryUpdated=true;
                }
                cherryImageView.setOpacity(0);
                cheeryLabel.setText(String.valueOf(numCherry));
            }

        });
        characterTranslateTimeline.play();


        /*
        When the animation of the character has ended, it checks if the character is flipped or not or if the gameOver variable
        is set or not, and if either is true then it calls the character fall function for the falling animation of the character and
        ending the game.
        If they are not set then it changes the currentPlatform and it also changes the number of the current platform
        to the platform that the character is standing on after the animation of the character moving on the line.
        After that if the game is not over, it calls the function to move the character and the platform to the start of the anchorpane.
         */
        characterTranslateTimeline.setOnFinished(event -> {

            if(currentPlatformNumber==1){
                currentPlatformNumber=2;
                this.currentPlatform=platform2;
            }
            else{
                currentPlatformNumber=1;
                this.currentPlatform=platform1;
            }
            System.out.println(gameCharacterPane.getLayoutX());
            if(gameOver || characterFlipped){
                characterFall();
            }
            else{
                moveCharacterAndPlatformToStart(currentPlatform,nextPlatform);
            }

        });


    }

    /*
    This function is used to move the character and the platform to the start of the anchorpane
     */
    public void moveCharacterAndPlatformToStart(Rectangle previousPlatform,Rectangle currentPlatform){
        /*
        This function first sets the opacity of the cherry to 0 so that it does not look weird during the movement
        of the character and the platform towards the back of the screen.
        Then it updates the current score and the best score if the current score is more than the best score.
         */
        cherryImageView.setOpacity(0);
        line.setOpacity(0);
        if(isLoaded()){
            currentScore = (getPlayer1().getCurrentScore()+1);

        }
        else currentScore++;
        getPlayer1().setCurrentScore(getPlayer1().getCurrentScore()+1);

        if(getBestScore()<currentScore){
            setBestScore(currentScore);
        }

        /*
        Then it uses a previousPlatformTimeline to animate the movement of the previous platform backwards.
        Its keyframe value is set to -1000 i.e. the previous platform moves to the position -1000 horizontally
        relative to the anchorPane, and it moves in a duration of 1 second.
         */
        Timeline previousPlatformTimeline = new Timeline();
        KeyFrame previousPlatformEnd = new KeyFrame(Duration.millis(1000), new KeyValue(previousPlatform.layoutXProperty(), -1000));
        previousPlatformTimeline.getKeyFrames().add(previousPlatformEnd);
        previousPlatformTimeline.play();
        currentScoreLabel.setText(Integer.toString(currentScore));
        previousPlatformTimeline.setOnFinished(event -> {
            System.out.println("previousPlatform="+previousPlatform.getLayoutX());
        });

        /*
        Then there is a character timeline that moves the character to the start
        , along with it the current platform is also moved to the start, if the platform is bigger than 100
        in width then the platform is moved such that only the right 100 pixels of the platform are on the screen.
        Right after the animation finishes the initEverything function is also called for initialising everything for the
        next part.
         */
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

            timeline.setOnFinished(event -> {
                System.out.println(currentPlatform.getLayoutX());
                currentPlatform.setWidth(100);
                currentPlatform.setLayoutX(0);
                gameCharacterPane.setLayoutX(currentPlatform.getWidth()-25);
                pauseButton.setDisable(false);
                initEverything();

            });
        }
        else{

            Timeline timeline = new Timeline();
            KeyFrame end = new KeyFrame(Duration.millis(1000), new KeyValue(currentPlatform.layoutXProperty(), 0));
            KeyFrame characterEnd=new KeyFrame(Duration.millis(1000),new KeyValue(gameCharacterPane.layoutXProperty(),(currentPlatform.getWidth()-25)));
            characterTimeline.getKeyFrames().add(characterEnd);
            characterTimeline.play();
            timeline.getKeyFrames().add(end);
            timeline.play();
            timeline.setOnFinished(event -> {
                System.out.println(currentPlatform.getLayoutX());
                currentPlatform.setWidth(currentPlatform.getWidth());
                currentPlatform.setLayoutX(0);
                gameCharacterPane.setLayoutX(currentPlatform.getWidth()-25);
                pauseButton.setDisable(false);
                initEverything();
            });
        }


    }

    /*
    This function is called when the pole end is ahead of the platform width or the
    pole length is before the start of the next platform.
    or when the character is flipped when he reaches the starting of the next platform.
     */
    public void characterFall(){
        /*
        There is a character fall timeline which just animates the character falling vertically on hitting the platform
        or on not reaching the platform or on going ahead of the platform.
        There is a keyframe according to which the layoutY property is changing from current to 800 in 250 milliseconds.
         */
        Timeline characterFallTimeline=new Timeline();
        KeyFrame characterFallEnd=new KeyFrame(Duration.millis(250),new KeyValue(gameCharacterPane.layoutYProperty(),800));
        characterFallTimeline.getKeyFrames().add(characterFallEnd);
        characterFallTimeline.play();
        characterFallTimeline.setOnFinished(actionEvent -> {
            //gameOverScreenAnchorPane.setLayoutX(0);
            /*
            This try block is supposed to catch the IOException for the fxml file of
            Game over screen.
             */
            try {
                /*
                This code is communicating to the gameOver controller to set the best score, the current score,
                and the total number of cherries as well.
                Then this code switches to the gameOver screen.
                 */
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

    /*
    This function is supposed to initialise everything in the code again according to the current platform that the
    player is standing on and so that the game can move on to the next part.
     */
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
            nextPlatformWidth= player1.randomWidth(currentPlatform.getWidth(),gap);
            nextPlatformPosition = player1.randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);
            platform2.setOpacity(1);
            platform2.setWidth(nextPlatformWidth);
            platform2.setHeight(platformHeight);
            platform2.setLayoutX(nextPlatformPosition);
            platform2.setLayoutY(platform2Details.getPositionY());
            cherryImageView.setOpacity(1);
            cherryImageView.setLayoutY(350);
            cherryPosition = player1.randomCherryX(platform1.getWidth(),platform2.getLayoutX());
            cherryImageView.setLayoutX(cherryPosition);

        }
        else{
            //currentPlatform=platform2;
            nextPlatformWidth= player1.randomWidth(currentPlatform.getWidth(),gap);
            nextPlatformPosition = player1.randomPos(currentPlatform.getWidth(),nextPlatformWidth,gap);

            platform1.setOpacity(1);
            platform1.setWidth(nextPlatformWidth);
            platform1.setHeight(platformHeight);
            platform1.setLayoutX(nextPlatformPosition);
            platform1.setLayoutY(platform1Details.getPositionY());
            cherryImageView.setOpacity(1);
            cherryImageView.setLayoutY(350);
            cherryPosition = player1.randomCherryX(platform2.getWidth(),platform1.getLayoutX());
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

    /*
    These 2 functions are for communicating to the controllers such as load
    screen controller and the pause menu controller as well.
     */
    public void setNumCherryAndLabel(int numCherry){
        this.numCherry=numCherry;
        cheeryLabel.setText(String.valueOf(numCherry));
    }
    public void setCurrentScoreAndLabel(int currentScore){
        this.currentScore=currentScore;
        currentScoreLabel.setText(String.valueOf(currentScore));
    }

    /*
    These are the music related functions for setting the music
    adapter and initialising sounds and also mute and unmute the music.
     */
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

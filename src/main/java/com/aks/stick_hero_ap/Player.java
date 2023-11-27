package com.aks.stick_hero_ap;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Player{
    private double positionX;
    private double positionY;
    private int cherriesCollected;
    private boolean isMoving;
    private boolean isFlipped;
    private int currentScore;
    private boolean isFallen;
    private float poleLength = 0;
    private boolean poleStatus = false;
    private float poleX;
    private float poleY;
    private float poleZ;
    private double cherryX;
    private double cherryY;
    private Platform firstPlatform;
    private Platform secondPlatform;
    private double platformDistance;
    private double platformPosition;

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public float getPoleLength() {
        return poleLength;
    }

    public void setPoleLength(float poleLength) {
        this.poleLength = poleLength;
    }

    public boolean getPoleStatus() {
        return poleStatus;
    }

    public void setPoleStatus(boolean poleStatus) {
        this.poleStatus = poleStatus;
    }

    public double getCherryX() {
        return cherryX;
    }

    public void setCherryX(double cherryX) {
        this.cherryX = cherryX;
    }

    public double getCherryY() {
        return cherryY;
    }

    public void setCherryY(double cherryY) {
        this.cherryY = cherryY;
    }

    public boolean isMouserel() {
        return mouseReleasedStatus;
    }

    public void setMouserel(boolean mouserel) {
        this.mouseReleasedStatus = mouserel;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public int getCherriesCollected() {
        return cherriesCollected;
    }

    public void setCherriesCollected(int cherriesCollected) {
        this.cherriesCollected = cherriesCollected;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public boolean isFallen() {
        return isFallen;
    }

    public void setFallen(boolean fallen) {
        isFallen = fallen;
    }

    public Platform getFirstPlatform() {
        return firstPlatform;
    }

    public void setFirstPlatform(Platform firstPlatform) {
        this.firstPlatform = firstPlatform;
    }

    public Platform getSecondPlatform() {
        return secondPlatform;
    }

    public void setSecondPlatform(Platform secondPlatform) {
        this.secondPlatform = secondPlatform;
    }

    public double getPlatformDistance() {
        return platformDistance;
    }

    //Initialise Platform Distance for every pair of platforms
    public void setPlatformDistance(double platformDistance) {
        this.platformDistance = secondPlatform.getStartPosition() - firstPlatform.getEndPosition(); //The distance between the Platform = (Second Platform's Starting Point - First Platform's Ending Point)
    }

    public double getPlatformPosition() {
        return platformPosition;
    }

    public void setPlatformPosition(double platformPosition) {
        this.platformPosition = platformPosition;
    }

    //Initialise Both Platforms with Random Values
    void initPlatforms(){
        //firstPlatform = new Platform();
        //secondPlatform = new Platform();
    }

    //Initialise Random Positions for Cherry
    void initCherry(){
        //setCherryX();
        //setCherryY();
    }
    void movePlayer(){
        while(!isFallen()){
            while(getPoleLength() >= getPositionX()) {
                setPositionX(getPositionX()+0.1); //increments X-axis of player while X < (Pole Length)
            }
            if(getPositionX() < platformDistance) setFallen(true); // if Pos-X is lesser than platform distance, player would fall down
            else{
                while(getPositionX() < secondPlatform.getWidth()){
                    setPositionX(getPositionX()+0.1); //increments X-axis of player while X < Width of Second Platform
                }
            }
        }
    };

    void flipPlayer(){
        setFlipped(!isFlipped()); //flips player to opposite of whatever the current status is
    }
//    void drawLine(){
//        startExtendingPole();
//    };
    void getPosition(){};
    int getScore(){
        return 0;
    };
    int getCherry(){
        return 0;
    };
    void getFallenStatus(){};

    void setPosition(double X, double Y){};
    void setCherry(){};
    void setFallenStatus(){};
    void setScore(){};

//    public void KeyTime(KeyEvent key){
//        long keyPressTime = 0;
//        getScene().setOnKeyPressed(keyEvent -> {
//            if(key.getCode().isWhitespaceKey()) keyPressTime = (System.currentTimeMillis());
//        });
//
//        getScene().setOnKeyReleased(keyEvent -> {
//            long keyReleaseTime = 0;
//            if(key.getCode().isWhitespaceKey()) keyReleaseTime = (System.currentTimeMillis());
//            System.out.println(keyReleaseTime - keyPressTime);
//
//        });
//    }

    boolean mouseReleasedStatus = false;
    public void mousereleased(){
        getScene().setOnMouseReleased(mouseEvent -> {
            mouseReleasedStatus = true;
            stopExtendingPole();
        });
    }

    private Scene getScene() {
        return new Scene(new StackPane());
    }

    void startExtendingPole(){
        setPoleStatus(true);
        getScene().setOnMousePressed(mouseEvent -> {
            while(!mouseReleasedStatus){
                poleLength += 0.1;
                mousereleased();
            }
        });
    };
    void stopExtendingPole(){
        setPoleStatus(false);
    };
//    void generatePillar(){
//        if(!getPoleStatus()) startExtendingPole();
//    };
    void rotatePole(){
        if(!getPoleStatus() & getPoleLength()!= 0){
            this.poleY = getPoleLength();
            float x = this.poleX;
            float y = this.poleY;
            while(this.poleZ != getPoleLength()){
                this.poleZ = (float) Math.sqrt(Math.pow(x+0.5,2) + Math.pow(y-0.5,2));
            }
        }
    };

}

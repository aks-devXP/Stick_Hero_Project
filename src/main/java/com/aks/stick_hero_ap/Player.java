package com.aks.stick_hero_ap;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.concurrent.ThreadLocalRandom;

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

    public double randomWidth(){
        double upperBound = 500; // upper bound of Width of Platform
        double lowerBound = 100; // lower bound of Width of Platform
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    public double randomPos(){
        double upperBound = 500; // upper bound of Position of Platform
        double lowerBound = 100; // lower bound of Position of Platform
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    public double randomCherryX(){
        double upperBound = 500; // upper bound of Position of Cherry - X axis
        double lowerBound = 100; // lower bound of Position of Cherry - X axis
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    public double randomCherryY(){
        double upperBound = 500; // upper bound of Position of Cherry - Y axis
        double lowerBound = 100; // lower bound of Position of Cherry - Y axis
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    //Initialise Both Platforms with Random Values
    void initPlatforms(){
        double width1 = randomWidth(); // Generating Random Width of Platform 1
        double width2 = randomWidth(); // For Platform 2 (Random Width)
        double start1 = randomPos(); // Generating Random Starting for Platform 1
        double start2 = randomPos(); // For Platform 2 (Random Starting)
        double end1 = randomPos();
        double end2 = randomPos();
        double height = 20; // Fixed Height of All platforms
        firstPlatform = new Platform(width1,height,start1,end1);
        secondPlatform = new Platform(width2,height,start2,end2);
    }

    // Initialising Second Platform After Moving
    void newPlatform(){
        double width = randomWidth();
        double start = randomPos();
        double end = randomPos();
        double height = 20; // Fixed Height for All Platforms
        firstPlatform = secondPlatform; // Second Platform becomes First Platform after Moving towards it
        secondPlatform = new Platform(width,height,start,end); // Second Platform is Re-Generated with Random Values
    }

    //Initialise Random Positions for Cherry
    void initCherry(){
        setCherryX(randomCherryX()); // Generating Value for X-axis of Cherry
        setCherryY(randomCherryY()); // Generating Value for Y-axis of Cherry
    }

    //Implementing Logics for Moving Player after Drawing Stick-Pole
    void movePlayer(){
        while(!isFallen()){ // While Player has not fallen down, it would move
            while(getPoleLength() >= getPositionX()) setPositionX(getPositionX()+0.1); //increments X-axis of player, upto Pole-Length Created by Player
            if(getPositionX() < platformDistance) setFallen(true); // if Pos-X is lesser than platform distance, player would fall down

            else{ // Player has reached the Second Platform
                while(getPositionX() < secondPlatform.getWidth()){ // Moving Player upto End-point of Second Platform
                    setPositionX(getPositionX()+0.1); //increments X-axis of player while X < Width of Second Platform
                }
            }
        }
    }

    // Flips the Player whenever Function is Called
    void flipPlayer() {setFlipped(!isFlipped());}

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

    boolean mouseReleasedStatus = false;
    public void mouseReleased(){
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
                mouseReleased();
            }
        });
    };
    void stopExtendingPole(){
        setPoleStatus(false);
        //System.out.println("Completed");
    };
//    void generatePillar(){
//        if(!getPoleStatus()) startExtendingPole();
//    };
    void rotatePole(){
        if(!getPoleStatus() & getPoleLength()!= 0){ // if Pole Length is non-zero & Pole has been Initialised
            this.poleY = getPoleLength(); // Y-axis of Pole is set to Length of Pole
            float x = this.poleX; // Temporary Storage of Pole-X
            float y = this.poleY; // Temp Storage of Pole-Y
            while(x != getPoleLength() & y!= 0){ // X has not reached Pole Length and Y has not reached Base Level (Assuming 0 for now)
                x += 0.1; // Pole changes Temporary Coordinates
                y -= 0.1;
                this.poleZ = (float) Math.sqrt(Math.pow(x+0.5,2) + Math.pow(y-0.5,2));
            }
        }
    };

}

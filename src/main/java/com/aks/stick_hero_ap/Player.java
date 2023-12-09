package com.aks.stick_hero_ap;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Player implements Serializable {
    private static Player player = null;
    private double positionX;
    private double positionY;
    private int cherriesCollected;
    private boolean isAlive;
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

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    public Player getPlayerInstance(){ //Singleton Method
        if(player == null){
            player = new Player();
        }
        return player;
    }

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public double randomWidth(double currentPlatformWidth,double gap){
        double upperBound = 300-(4*gap)-currentPlatformWidth; // upper bound of Width of Platform
        double lowerBound = 25; // lower bound of Width of Platform
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    public double randomPos(double currentPlatformWidth,double nextPlatformWidth,double gap){
        double upperBound = 300-nextPlatformWidth-gap; // upper bound of Position of Platform
        double lowerBound = currentPlatformWidth+gap; // lower bound of Position of Platform
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }

    public double randomCherryX(double currentPlatformWidth,double nextPlatformLayoutX){
        double upperBound = nextPlatformLayoutX-23; // upper bound of Position of Cherry - X axis
        double lowerBound = currentPlatformWidth; // lower bound of Position of Cherry - X axis
        return ThreadLocalRandom.current().nextDouble(lowerBound, upperBound + 1); // Used ThreadLocalRandom as it may be required in thread pool by multiple processes
    }



    //Initialise Both Platforms with Random Values
    void initPlatforms(){
        //double width1 = randomWidth(); // Generating Random Width of Platform 1
        //double width2 = randomWidth(); // For Platform 2 (Random Width)
        //double start1 = randomPos(); // Generating Random Starting for Platform 1
        //double start2 = randomPos(); // For Platform 2 (Random Starting)
        //double end1 = randomPos();
        //double end2 = randomPos();
        double height = 20; // Fixed Height of All platforms
        //firstPlatform = new Platform(width1,height,start1,end1);
        //secondPlatform = new Platform(width2,height,start2,end2);
    }

    // Initialising Second Platform After Moving
    void newPlatform(){
        //double width = randomWidth();
        //double start = randomPos();
        //double end = randomPos();
        double height = 20; // Fixed Height for All Platforms
        firstPlatform = secondPlatform; // Second Platform becomes First Platform after Moving towards it
        //secondPlatform = new Platform(width,height,start,end); // Second Platform is Re-Generated with Random Values
    }

    //Initialise Random Positions for Cherry
    void initCherry(){
        //setCherryX(randomCherryX()); // Generating Value for X-axis of Cherry

    }

    // Flips the Player whenever Function is Called
    void flipPlayer() {setFlipped(!isFlipped());}
    void getPosition(){};
    int getScore(){
        return 0;
    };
    int getCherry(){
        return 0;
    };

    void setPosition(double X, double Y){};
    void setCherry(){};
    void setFallenStatus(){};
    void setScore(){};

    void revivePlayer(){
        if(!isAlive()){
            setAlive(true);
        }
    }
    private Scene getScene() {
        return new Scene(new StackPane());
    }

}

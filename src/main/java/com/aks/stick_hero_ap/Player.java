package com.aks.stick_hero_ap;

public class Player extends GameController{
    private double positionX;
    private double positionY;
    private int cherriesCollected;
    private boolean isMoving;
    private int currentScore;
    private boolean isFallen;

    private Platform firstPlatform;
    private Platform secondPlatform;
    private double platformDistance;
    private double platformPosition;

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

    public void setPlatformDistance(double platformDistance) {
        this.platformDistance = platformDistance;
    }

    public double getPlatformPosition() {
        return platformPosition;
    }

    public void setPlatformPosition(double platformPosition) {
        this.platformPosition = platformPosition;
    }

    void movePlayer(){};
    void drawLine(){};
    void getPosition(){};
    void getFlipped(){};
    void getScore(){};
    void getCherry(){};
    void getFallenStatus(){};

    void setPosition(double X, double Y){};
    void setCherry(){};
    void setFallenStatus(){};
    void setScore(){};

    void startExtendingPole(){};
    void stopExtendingPole(){};
    void generatePillar(){};
    void rotatePole(){};


}

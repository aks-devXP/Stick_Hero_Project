package com.aks.stick_hero_ap;

public class Platform{
    private static Player player;
    private double width;
    private double height;
    private double startPosition;
    private double endPosition;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Platform.player = player;
    }

    public Player getPlayerInstance(){
        if(player == null){
            setPlayer(Player.getPlayerInstance());
        }
        return player;
    }

    //@Override
    public double getPositionX() {
        return positionX;
    }

    //@Override
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    //@Override
    public double getPositionY() {
        return positionY;
    }

    //@Override
    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    private double positionX;      //These are both supposed to be layoutX and
    private double positionY;      // LayoutY

    //Constructor for Platform
    public Platform(double width, double height, double positionX, double positionY) {
        this.width = width;
        this.height = height;
        this.positionX=positionX;
        this.positionY=positionY;
    }

    public Platform(){
    }       //empty constructor

    public double getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(double endPosition) {
        this.endPosition = endPosition;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(double startPosition) {
        this.startPosition = startPosition;
    }
}

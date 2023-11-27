package com.aks.stick_hero_ap;

public class Platform extends Player {
    private double width;
    private double height;
    private double startPosition;
    private double endPosition;

    public Platform(double width, double height, double startPosition, double endPosition) {
        this.width = width;
        this.height = height;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

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

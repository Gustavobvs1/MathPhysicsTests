package org.example.math;

public class Position {
    private double x;
    private double y;

    //Getters e Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //Constructor
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

}

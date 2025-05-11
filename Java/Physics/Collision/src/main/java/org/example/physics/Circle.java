package org.example.physics;

import org.example.math.Position;

import java.awt.*;

public class Circle {
    private double radius;
    private Position position;
    private Color color;

    public double getRadius() {
        return radius;
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public Circle(double radius, Position position, Color color) {
        this.radius = radius;
        this.position = position;
        this.color = color;
    }


}

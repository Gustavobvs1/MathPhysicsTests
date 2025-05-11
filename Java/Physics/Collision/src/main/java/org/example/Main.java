package org.example;

import org.example.math.Position;
import org.example.physics.Circle;
import org.example.window.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int width = 512;
        int height = 512;
        int fps = 60;

        List<Circle> circleList = new ArrayList<Circle>();

        Position position = new Position((double) width/2,(double) height/2);
        Circle circle1 = new Circle((double) Math.min(width, height) *  1/8, position, new Color(100,210,210));

        Circle circle2 = new Circle((double) Math.min(width, height) *  1/8, position, new Color(100,0,100));

        circleList.add(circle1);
        circleList.add(circle2);

        Screen screen = new Screen(width, height, fps, circleList);
        Thread animator = new Thread(screen);

        animator.start();

    }
}
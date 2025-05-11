package org.example.window;

import org.example.physics.Circle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

public class Camera extends Canvas  {

    private final int width;
    private final int height;
    private final Color color;
    private final List<Circle> circles;

    public Camera(int width, int height, Color color, List<Circle> circles) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.circles = circles;

        this.setSize(width,height);
        this.setBackground(color);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                circles.get(0).getPosition().setX(e.getX());
                circles.get(0).getPosition().setY(e.getY());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        for(Circle circle: circles) {
            int x = (int) circle.getPosition().getX();
            int y = (int) circle.getPosition().getY();
            int radius = (int) circle.getRadius();
            circle.getPosition().setX(circle.getPosition().getX() + 1);
            g.setColor(circle.getColor());
            g.fillArc(x - radius,y - radius,radius * 2,radius * 2,0,360);
        }

    }
}

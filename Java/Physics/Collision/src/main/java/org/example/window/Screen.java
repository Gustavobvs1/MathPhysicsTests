package org.example.window;

import org.example.physics.Circle;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Screen extends JFrame implements Runnable {
    private final Dimension screenSize;
    private final int fps;
    private final double frameDuration;
    private final double deltaTime;
    private final Camera camera;
    private boolean running;

    public Screen(int width, int heigth, int fps, List<Circle> circles) {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.fps = fps;
        this.frameDuration = 1000/fps;
        this.deltaTime = frameDuration/1000;
        this.camera = new Camera(width, heigth, new Color(0,0,0), circles);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation((screenSize.width - width)/2,  (screenSize.height - heigth)/2);
        this.setTitle("Collision");
        this.setVisible(true);
        this.running = true;

        this.add(camera);

        this.pack();
    }

    @Override
    public void run() {
        while(running) {
            try {
                camera.repaint();
                Thread.sleep((int) this.frameDuration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

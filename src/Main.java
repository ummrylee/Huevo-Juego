import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        DisplayManager drawing = new DisplayManager("example.egg");
        PApplet.runSketch(new String[]{""}, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame)canvas.getFrame();

        // 7, 30 used to make surface itself perfectly square
        window.setSize(500, 500);
        window.setMinimumSize(new Dimension(100,100));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);
        canvas.requestFocus();
    }

}

package fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);
        
        Orientation nw = new Orientation();
        Orientation sw = new Orientation();
        Orientation se = new Orientation();
        
        Fractal fractal = new Fractal();
        
        layout.putConstraint(SpringLayout.WEST, fractal, 5, SpringLayout.WEST, frame.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, fractal, 5, SpringLayout.NORTH, frame.getContentPane());
        
        layout.putConstraint(SpringLayout.WEST, nw, 5, SpringLayout.EAST, fractal);
        layout.putConstraint(SpringLayout.NORTH, nw, 0, SpringLayout.NORTH, fractal);
        
        layout.putConstraint(SpringLayout.NORTH, sw, 5, SpringLayout.SOUTH, nw);
        layout.putConstraint(SpringLayout.WEST, sw, 0, SpringLayout.WEST, nw);
        
        layout.putConstraint(SpringLayout.NORTH, se, 5, SpringLayout.SOUTH, nw);
        layout.putConstraint(SpringLayout.WEST, se, 5, SpringLayout.EAST, sw);
        
        layout.putConstraint(SpringLayout.SOUTH, frame.getContentPane(), 5, SpringLayout.SOUTH, fractal);
        layout.putConstraint(SpringLayout.EAST, frame.getContentPane(), 5, SpringLayout.EAST, se);
        
        frame.add(nw);
        frame.add(sw);
        frame.add(se);
        
        frame.add(fractal);
        
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

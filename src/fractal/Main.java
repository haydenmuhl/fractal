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
        frame.setSize(new Dimension(700, 500));
        
        Orientation nw = new Orientation();
        Orientation sw = new Orientation();
        Orientation se = new Orientation();
        
        layout.putConstraint(SpringLayout.WEST, nw, 5, SpringLayout.WEST, frame.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, nw, 5, SpringLayout.NORTH, frame.getContentPane());
        
        layout.putConstraint(SpringLayout.NORTH, sw, 5, SpringLayout.SOUTH, nw);
        layout.putConstraint(SpringLayout.WEST, sw, 5, SpringLayout.WEST, frame.getContentPane());
        
        layout.putConstraint(SpringLayout.NORTH, se, 5, SpringLayout.SOUTH, nw);
        layout.putConstraint(SpringLayout.WEST, se, 5, SpringLayout.EAST, sw);
        
        frame.add(nw);
        frame.add(sw);
        frame.add(se);
        
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

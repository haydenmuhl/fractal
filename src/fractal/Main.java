package fractal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(700, 500));
        
        frame.add(new JButton("one"));
        frame.add(new JButton("two"));
        
        Orientation c = new Orientation();
        c.setSize(new Dimension(300, 300));
        frame.add(c);
        
        frame.add(new JLabel("three"));
        
//        frame.pack();
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

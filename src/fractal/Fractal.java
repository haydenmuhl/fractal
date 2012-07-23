package fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Fractal extends Canvas implements ActionListener, MouseListener {
    private int regionSize;
    
    private BufferedImage im;
    
    private int x = 0;
    private int y = 0;
    
    private Random random = new Random();
    private Timer timer;
    
    private Orientation[] regions = new Orientation[3];
    private boolean clear;
    
    public Fractal(int size) {
        regionSize = size;
        timer = new Timer(1, this);
        timer.start();
        im = new BufferedImage(regionSize * 2, regionSize * 2, BufferedImage.TYPE_3BYTE_BGR);
        
        clear();
    }
    
    public void clear() {
        clear = true;
        Graphics g = im.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, regionSize * 2, regionSize * 2);
        repaint();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(regionSize * 2, regionSize * 2);
    }
    
    public void paint(Graphics g) {
        g.drawImage(im, 0, 0, this);
    }
    
    public void update(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 1, 1);
        Graphics ig = im.getGraphics();
        ig.setColor(Color.black);
        ig.fillRect(x, y, 1, 1);
        if (clear) {
            clear = false;
            paint(g);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        Orientation region = regions[random.nextInt(3)];
        x = x / 2;
        y = y / 2;
        if (region.getSwitchX()) {
            x = regionSize - x;
        }
        if (region.getSwitchY()) {
            y = regionSize - y;
        }
        if (region.getTranspose()) {
            int temp = x;
            x = y;
            y = temp;
        }
        x = x + region.getXOffset();
        y = y + region.getYOffset();
        
        repaint();
    }
    
    public void setOrientations(Orientation nw,
                                Orientation sw,
                                Orientation se) {
        regions[0] = nw;
        regions[1] = sw;
        regions[2] = se;
        for (Orientation r : regions) {
            r.addMouseListener(this);
        }
    }
    
    public void mouseEntered (MouseEvent e) {
    
    }
    
    public void mouseExited (MouseEvent e) {
    
    }
    
    public void mouseClicked (MouseEvent e) {
        clear();
    }
    
    public void mousePressed (MouseEvent e) {
    
    }
    
    public void mouseReleased (MouseEvent e) {
    
    }
}

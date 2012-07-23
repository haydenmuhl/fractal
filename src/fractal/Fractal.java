package fractal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Fractal extends Canvas implements ActionListener{
    private int regionSize = 200;
    
    private Image im;
    
    private int x = 0;
    private int y = 0;
    
    private Random random = new Random();
    private Timer timer;
    
    public Fractal() {
        timer = new Timer(1, this);
        timer.start();
        im = new BufferedImage(regionSize * 2, regionSize * 2, BufferedImage.TYPE_BYTE_BINARY);
        clear();
    }
    
    public void clear() {
        Graphics g = im.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, regionSize * 2, regionSize * 2);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(regionSize * 2, regionSize * 2);
    }
    
    public void paint(Graphics g) {
        g.drawImage(im, 0, 0, this);
        update(g);
    }
    
    public void update(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 1, 1);
        g = im.getGraphics();
        g.setColor(Color.black);
        g.fillRect(x, y, 1, 1);
    }
    
    public void actionPerformed(ActionEvent e) {
        int region = random.nextInt(3);
        x = x / 2;
        y = y / 2;
        if (region > 0) {
            y = y + regionSize;
        }
        if (region > 1) {
            x = x + regionSize;
        }
        repaint();
    }
}

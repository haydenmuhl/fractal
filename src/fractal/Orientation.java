package fractal;

import java.awt.*;
import java.awt.event.*;

public class Orientation extends Component {
    
    private int[] xCoords = {10, 10, 50, 50, 20, 20};
    private int[] yCoords = {10, 90, 90, 80, 80, 10};
    
    private int xOffset;
    private int yOffset;
    
    private boolean switchX = false;
    private boolean switchY = false;
    private boolean transpose = false;
    
    public Orientation() {
        super();
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    
    public void setOffset(int x, int y) {
        xOffset = x;
        yOffset = y;
    }
    
    public int getXOffset() {
        return xOffset;
    }
    
    public int getYOffset() {
        return yOffset;
    }
    
    public boolean getSwitchX() {
        return switchX;
    }
    
    public boolean getSwitchY() {
        return switchY;
    }
    
    public boolean getTranspose() {
        return transpose;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
    
    @Override
    public void paint(Graphics g) {
        Dimension d = g.getClipBounds().getSize();
        int x = d.width;
        int y = d.height;
        
        g.setColor(Color.white);
        g.fillRect(0, 0, x, y);
        
        g.setColor(Color.black);
        g.fillPolygon(xCoords, yCoords, xCoords.length);
    }
    
    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_CLICKED) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                mirror();
            }
            if (e.getButton() == MouseEvent.BUTTON1) {
                rotate();
            }
            for (MouseListener m : getMouseListeners()) {
                m.mouseClicked(e);
            }
            repaint();
        }
    }
    
    private void rotate() {
        int[] coordArray = xCoords;
        xCoords = yCoords;
        yCoords = coordArray;
        for (int i = 0; i < xCoords.length; i++) {
            xCoords[i] = 100 - xCoords[i];
        }
        
        boolean t = transpose;
        boolean x = switchX;
        boolean y = switchY;
        
        transpose = !t;
        switchY = !t ^ y;
        switchX = t ^ x;
    }
    
    private void mirror() {
        int[] coordArray;
        if (transpose) {
            coordArray = yCoords;
        } else {
            coordArray = xCoords;
        }
        for (int i = 0; i < coordArray.length; i++) {
            coordArray[i] = 100 - coordArray[i];
        }
        
        switchX = !switchX;
    }
}

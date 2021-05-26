package button;
import ivisible.IVisible;
import figures.Figure;
import java.awt.event.*;

import java.awt.*;
public class Button implements IVisible {
    public int x, y;
    static int aux = 36;
    public  int    idx;
    private Figure fig;
    public boolean focused;
	
	
    public Button (int idx, Figure fig) {
    
	      this.idx = idx;
        this.fig = fig;
        this.focused=false;
        this.x = (-20 +(aux*idx))/2;
        this.y = 20 + (idx * aux);
       
    }

    public boolean contains (MouseEvent evt) {
        return evt.getX() >= this.x && evt.getX() <= this.x + aux && evt.getY() >= this.y && evt.getY() <= this.y + aux;
    }

   public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fillRect (this.x,this.y, aux, aux);
        g2d.setColor(Color.BLACK);
		    g2d.drawRect(this.x,this.y, aux,aux);
		    this.fig.paint(g, false);


    }
}

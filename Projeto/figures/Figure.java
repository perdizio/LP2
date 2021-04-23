package figures;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int w, h;
	public Color corBorda, cb;

	

    public  Figure (int x, int y, int w, int h, Color corBorda, Color cb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.corBorda=corBorda;
		this.cb=cb;
    }

    public void drag (int dx, int dy, Point p) {
        this.x += dx;
        this.y += dy;
    }

    public abstract void paint (Graphics g);
    public abstract boolean contains(MouseEvent evt);
		public abstract void colorFig(Color b);
			
		

}

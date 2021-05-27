package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import java.awt.event.*;

 public class Ellipse  extends Figure {
    int x, y;
    int w, h;
	Color a;
	Color b;
	Ellipse2D  e;

    public Ellipse (int x, int y, int w, int h,Color corBorda, Color cb) {
				 super(x, y,w,h,corBorda,cb);

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.corBorda=corBorda;
		this.cb=cb;
        this.e = new Ellipse2D.Double(this.x, this.y, this.w, this.h);

    }
	  

	public void colorFig(Color cb){
		this.cb=cb;
		
	}
	
	
	
	 public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
		
		if(focused){
		g2d.setColor(this.corBorda);
        g2d.draw(this.e);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		}
		
        g2d.setColor(this.corBorda);
        g2d.draw(this.e);
        g2d.setColor(this.cb);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	}


	
	 public boolean contains(MouseEvent evt) {
        if (this.e.contains(evt.getPoint()))
            return true;
        return false;
    }
	
	
	
	public void drag(int x,int y, Point p){
        this.x+=x;
        this.y+=y;
        this.e = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }
}


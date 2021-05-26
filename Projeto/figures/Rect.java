package figures;

import java.awt.*;
import java.awt.event.*;

public class Rect extends Figure {
	Color cb;
	//Color corBorda;
	Rectangle  r;
    public Rect (int x, int y, int w, int h, Color corBorda, Color cb) {
		 super(x, y,w,h,corBorda,cb);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corBorda = corBorda;
		this.cb=cb;
		this.r = new Rectangle(this.x, this.y, this.w, this.h);
    }
	

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

   public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        if(focused){
			   g2d.setColor(this.corBorda);
        g2d.draw(this.r);
           //g2d.setPaint(Color.RED);
        g2d.fillRect(this.x,this.y, this.w,this.h);
				}
        g2d.setColor(this.corBorda);
        g2d.draw(this.r);
        g2d.setColor(this.cb);
        g2d.fillRect(this.x,this.y, this.w,this.h);
	}


	 public boolean contains(MouseEvent evt) {
        if (this.r.contains(evt.getPoint()))
            return true;
        return false;
    }
	
		public void colorFig(Color cb){
			this.cb=cb;
			
			
		}
	
	
	public void drag(int x,int y, Point p){
        this.x+=x;
        this.y+=y;
        this.r = new Rectangle(this.x,this.y, this.w,this.h);
    }
	
	
}



package figures;
import java.awt.event.*;

import java.awt.*;

public class Triangulo  extends Figure{
	 int x, y;
	 int w, h;
	 Polygon p ;
	 Color a;
	 Color b;
       protected int[] x1, x2;

	public Triangulo (int x, int y, int w, int h,Color corBorda, Color cb){
        super(x, y,w,h,corBorda,cb);	
     
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corBorda = corBorda;
		this.cb=cb;
		int x1[]= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int x2[]={this.y, (this.y) - (this.h),this.y};
	 	this.p=new Polygon(x1, x2, 3);

    }
	

	public void colorFig(Color cb){
			this.cb=cb;
			
			
		}
		public void colorBorda(Color corBorda){
			this.corBorda=corBorda;
			
			
		}
	
	public void paint (Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
			if(focused){
			   g2d.setColor(this.corBorda);
        g2d.draw(this.p);
           //g2d.setPaint(Color.RED);
            g2d.fillPolygon(p);
				}
        g2d.setColor(this.corBorda);
        g2d.draw(this.p);
        g2d.setColor(this.cb);
        g2d.fillPolygon(this.p);
	}
	public boolean contains(MouseEvent evt) {
        if (this.p.contains(evt.getPoint()))
            return true;
        return false;
    }
	
	
	
	  public void drag(int x,int y, Point pos){
        this.x += x;
        this.y += y;
		int[] x1= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int[] x2={this.y, (this.y) - (this.h),this.y};
      
        this.p = new Polygon(x1, x2, 3);
    }
}


package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Pentagono  extends Figure{
	 int x, y;
	 int w, h;
	Polygon p ;
    public int[] x1, x2;
	 
	public  Pentagono (int x, int y, int w, int h,Color corBorda, Color cb){
        super(x, y,w,h,corBorda,cb);	
     
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corBorda = corBorda;
		this.cb=cb;
		                                //n            //n
		int x1[]= {this.x,(this.x+10),(this.x +25),(this.x + 40),(this.x + 20)};
		//int x1[]= {this.x,(this.x+15),(this.x + 30),(this.x + 50),(this.x + 30)};

		int x2[]={this.y,(this.y+25),(this.y+25),this.y,(this.y-40)};
			//	int x2[]={this.y,(this.y+25),(this.y+25),this.y,(this.y-40)};


		this.p=new Polygon(x1, x2, 5);
		
    }
	
	
	
	
	

	public void colorFig(Color cb){
			this.cb=cb;
			
			
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
      	
		int x1[]= {this.x,(this.x+15),(this.x + 55),(this.x + 78),(this.x + 40)};
		int x2[]={this.y,(this.y+40),(this.y+40),this.y,(this.y-40)};
              this.p = new Polygon(x1, x2, 5);
    }
}

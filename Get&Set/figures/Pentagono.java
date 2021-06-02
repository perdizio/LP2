
package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Pentagono  extends Figure{
	 int x, y;
	 int w, h;
	protected Polygon p ;
    private int[] x1, x2;
	 
	public  Pentagono (int x, int y, int w, int h,Color corBorda, Color cb){
        super(x, y,w,h,corBorda,cb);	
     
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corBorda = corBorda;
		this.cb=cb; 
		          //PT.LAT.DIRE        //base             //n                    //Pt. Lat. Esq              lateral intiera
		int x1[]= {this.x,          (this.x+5),          (this.x +25),               (this.x + 30),               (this.x + 15)};
		//int x1[]= {this.x,          (this.x+5),          (this.x +25),               (this.x + 30),               (this.x + 15)};
                         //parte B     
		int x2[]={this.y,(this.y+15),(this.y+15),this.y,(this.y-25)};
		//int x2[]={this.y,(this.y+15),(this.y+15),this.y,(this.y-25)};


		this.p=new Polygon(x1, x2, 5);
		
    }
	
	
	
	public void colorBorda(Color corBorda){
			this.corBorda=corBorda;
			
			
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
      	
		int x1[]= {this.x,(this.x+5),(this.x +25), (this.x + 30), (this.x + 15)};
		int x2[]={this.y,(this.y+15),(this.y+15),this.y,(this.y-25)};
              this.p = new Polygon(x1, x2, 5);
    }
}
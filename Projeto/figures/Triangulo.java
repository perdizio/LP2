 
package figures;

import java.awt.*;

public class Triangulo  extends Figure{
	 int x, y;
	 int w, h;
	 Polygon p = new Polygon();
	
	public Triangulo (int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;        
		//X
        p.npoints = 3;
        p.xpoints[0] = x ;
        p.xpoints[1] = y;
        p.xpoints[2] = w;
        
		//Y
        p.ypoints[0] = y;
        p.ypoints[1] = w ;
        p.ypoints[2] = y;
     
    }
	

	
	public void paint (Graphics g) {
		
        Graphics2D g2d = (Graphics2D) g;
		g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
    }
}

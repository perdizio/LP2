 
package figures;

import java.awt.*;

public class Triangulo {
	 int x, y;
	 int w, h;
	 Polygon p = new Polygon();
	
	public Triangulo (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        
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
	
	
	private void print () {
        System.out.format("Triangulo tamanho: (%d,%d) e posicao: (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }
	
	public void paint (Graphics g) {
		
        Graphics2D g2d = (Graphics2D) g;
		g2d.drawPolygon(p.xpoints, p.ypoints, p.npoints);
    }
}
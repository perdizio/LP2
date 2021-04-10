 package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

 public class Ellipse  extends Figure {
    int x, y;
    int w, h;
	Color a;
	Color b;

    public Ellipse (int x, int y, int w, int h, Color a, Color b) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.a=a;
		this.b=b;
    }
/*
    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }*/

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		  g2d.setColor(this.a);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        
        g2d.setColor(this.b);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));

    }
}

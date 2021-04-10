package figures;

import java.awt.*;

public class Rect  extends Figure {
    int x, y;
    int w, h;
	Color a;
	Color b;

    public Rect (int x, int y, int w, int h, Color a, Color b) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.a=a;
		this.b=b;
    }



   public void paint (Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(this.a);
            g2d.drawRect(this.x+1 , this.y+1, this.w-1, this.h-1);
            g2d.setColor(this.b);
            g2d.fillRect((this.x-1), (this.y-1), (this.w+1), (this.h+1)); 
            g2d.setColor(this.a); 
        

}
}

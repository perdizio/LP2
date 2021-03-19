import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;


class PackAppRet {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1,r2,r3;
	
	

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect");
        this.setSize(350, 350);
        this.r1 = new Rect(70,200, 100,50,  Color.black, Color.red); 
		this.r2 = new Rect(100,300, 110,40,  Color.blue, Color.green);
        this.r3 = new Rect(100,420, 150,50,  Color.yellow, Color.pink);

    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
		this.r2.paint(g);
        this.r3.paint(g);
    }
}


class Rect {
    int x, y;
    int w, h;
	Color a;
	Color b;

     Rect (int x, int y, int w, int h, Color a, Color b) {
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
  
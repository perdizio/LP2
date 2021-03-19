import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Ellipse e1, e2, e3;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Elipses");
        this.setSize(350, 350);
        this.e1 = new Ellipse(100,200, 100,30,  Color.black, Color.red); 
		this.e2 = new Ellipse(200,300, 110,40,  Color.blue, Color.green);
        this.e3 = new Ellipse(300,420, 150,50,  Color.yellow, Color.pink);

    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
		this.e2.paint(g);
        this.e3.paint(g);
    }
}
  class Ellipse {
    int x, y;
    int w, h;
	Color a;
	Color b;

     Ellipse (int x, int y, int w, int h, Color a, Color b) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.a=a;
		this.b=b;
    }
/*
    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackAppJava {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
     Triangulo t1;
     Rect r1;
     Ellipse e1;


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
        this.e1 = new Ellipse(300,420, 150,50,   Color.black, Color.red); 
		this.t1 = new Triangulo(100, 250, 200, 30);
        this.r1 = new Rect(100,300, 110,40,  Color.black, Color.red); 
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
		this.t1.paint(g);
        this.r1.paint(g);
    }
} 

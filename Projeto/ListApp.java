
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
public class ListApp{
    public static void main(String[] args) {
        PackFrame frame=new PackFrame();
        frame.setVisible(true);
    }
    
}
class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Point p;
    Random rand = new Random();
    Figure focus = null;
//Point p = getMousePosition();
  private static int MOVE_ESFERA_X = 0;
     private static int MOVE_ESFERA_Y = 0;

    Color a = null;
	  int w = 40;
      int h = 40;
    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
       
            this.addMouseListener (
            new MouseAdapter() {
                 public void mousePressed (MouseEvent evt) {
					 
                    p = getMousePosition();
					
			 if (focus != null) {
                        focus.corBorda = a;
                    }
					
                      //  focus.corBorda = a;
					  focus=null;
					for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                          focus = fig;
                            a = focus.corBorda;
						
                        }

                    }
					
					
					
                    if (focus != null) {
                     focus.corBorda=a;
					if(focus.corBorda != Color.red){
                            focus.corBorda = Color.red;
                        }
						//focus=null;
						 figs.remove(focus);
                        figs.add(focus);
						
                    }
					
					
                 
                    
					repaint();
                }
            }
            );

            this.addMouseMotionListener (
                new MouseMotionAdapter() {
                    public void mouseDragged (MouseEvent evt) {
					// p = getMousePosition();
					Point mousePressedPos=  evt.getPoint();
                    
						//(p.x , p.y, mousePressedPos);
                      //focus.drag(evt.getX()-p.x , evt.getY()-p.y);

                                focus.drag(evt.getX() - p.x, evt.getY() - p.y, mousePressedPos);
                      p = getMousePosition();

                       repaint();
                        
                    }
                }
            );

          this.addKeyListener (
            new KeyAdapter() {

                public void keyPressed (KeyEvent evt) {
					 Point p = getMousePosition();
                  int keyCode = evt.getKeyCode();
                    if (evt.getKeyChar() == 'e') {
						
						figs.add(new Ellipse(p.x,p.y,w,h,Color.black,Color.pink ));
						
						
    
                    }else if(evt.getKeyChar() == 'r'){
					
						figs.add(new Rect(p.x,p.y,w,h,Color.black,Color.pink )); //contorno
						
						
						
                    }
					
					
					//para baixo
					else if(evt.getKeyCode() == 40){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
					  focus.drag(0,1,p);

								
					}
					}}
					//para cima
					else if(evt.getKeyCode() == 38){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
								focus.drag(0 , -1,p);
					  //focus.drag(0 , -1,p);
                    repaint();

								
					}
					}}
					
					//para direita
					else if(evt.getKeyCode() == 39){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
					  focus.drag(1,0,p);
                    repaint();

								
					}
					}}
				//para esquerda
				else if(evt.getKeyCode() == 37){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
					  focus.drag(-1,0,p);
                    repaint();

								
					}
					}}	
					
					
                    repaint();
                    

                }
            }
        );
    

        this.setTitle("ListAPP");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}


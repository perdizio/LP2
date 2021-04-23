
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

    Color a = null;
	Color aux= null;
	  int w = 40;
      int h = 30;
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
				  
				  /*---------------------------------------------------------
					              CRIAÇÃO DAS 4 FIGURAS
				   ---------------------------------------------------------*/
				  
                    
					if (evt.getKeyChar() == 'e') {
						
						figs.add(new Ellipse(p.x,p.y,w,h,Color.black,Color.pink ));
						
						
    
                    }else if(evt.getKeyChar() == 'r'){
					
						figs.add(new Rect(p.x,p.y,w,h,Color.black,Color.pink )); 
						
						
					
					
					}else if(evt.getKeyChar() == 'l'){
					
						figs.add(new Line(0,0,w,h,Color.black,Color.pink )); 
						
						
						
                    }
					else if(evt.getKeyChar() == 't'){
					
						figs.add(new Triangulo(p.x,p.y,w,h,Color.black,Color.pink )); 
						
						
						
                    
					 }
					 else if(evt.getKeyChar() == 'p'){
					
						figs.add(new Pentagono(p.x,p.y,w,h,Color.black,Color.pink )); 
						
						
						
                    
					 }
					 
					 /*----------------------------------
							TAMANHO DAS FIGURAS
					  -----------------------------------*/
					 
					 else if(evt.getKeyChar() == '-'){
					
					
					
					       for(Figure fig: figs){
                            if(focus == fig){
								fig.w=fig.w-1;
								fig.h=fig.w-1;
						   }}
						                      // repaint();

						
						
                    
					
					 }else if(evt.getKeyChar() == '+'){
					
					
					
					       for(Figure fig: figs){
                            if(focus == fig){
								fig.w=fig.w+1;
								fig.h=fig.h+1;
						   }}
						                  //  repaint();

						
                    }
			/*------------------------------------------------------------------------------
			                         TROCA DE CORES
			  ------------------------------------------------------------------------------*/
					else if(evt.getKeyChar() == 'a' && focus!=null ){
	                           
							   focus.colorFig(Color.blue);
								
					}else if(evt.getKeyChar() == 'b' && focus!=null ){
	                           
							   focus.colorFig(Color.white);
								
								
					}else if(evt.getKeyChar() == 'c' && focus!=null ){
	                           
							   focus.colorFig(Color.green);
			    /*------------------------------------------------------------------------------
			                         Mexe com a posição das figuras
			     ------------------------------------------------------------------------------*/
								
					}else if(evt.getKeyCode() == 40){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
					         focus.drag(0,1,p);
		
					}
					}}
					/*----------------------------
					            CIMA
				      ---------------------------*/
					else if(evt.getKeyCode() == 38){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
								focus.drag(0 , -1,p);
					  //focus.drag(0 , -1,p);
                    repaint();

								
					}
					}}
					
					/*----------------------------
					            DIREITA
				      ---------------------------*/
					else if(evt.getKeyCode() == 39){
                      //Point p = getMousePosition();

					  	 for(Figure fig: figs){
                            if(focus == fig){
					  focus.drag(1,0,p);
                    repaint();

								
					}
					}}
				/*----------------------------
					        ESQUERDA
				  ---------------------------*/
				else if(evt.getKeyCode() == 37){
                      //Point p = getMousePosition();

					for(Figure fig: figs){
						if(focus == fig){
							focus.drag(-1,0,p);
							repaint();

								
						}
					}
				}	
				
				/*------------------------------------------------------------
					                REMOVE A FIGURA
				  ------------------------------------------------------------*/
				
				else if(evt.getKeyCode() == KeyEvent.VK_DELETE && focus!=null){
                            figs.remove(focus);
                            focus=null;
                    }
					
					/*---------------------
					            TAB
					-----------------------*/
					else if(evt.getKeyCode() == KeyEvent.VK_TAB ){
						
						 for(Figure fig: figs){
                            if(focus != fig){
                               
							   focus.corBorda = a;


						 
					}}}
					
					
					
					
					
					
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


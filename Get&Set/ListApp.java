
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import button.Button;
import ivisible.IVisible;
import java.io.*;


public class ListApp{
    public static void main(String[] args) {
        PackFrame frame=new PackFrame();
        frame.setVisible(true);
    }
    
}
class PackFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buttons= new ArrayList<Button>();

    Point p;
    Figure focus = null;
    Button focusB=null;


//Point p = getMousePosition();
     int index = 0;

    Color a = null;
	Color aux= null;
	  int w = 30;
      int h = 30;
    PackFrame () {
		
		
		try{
			
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();

			}catch(Exception x){
			System.out.println("ERRO!\n");
			}
		     
// direita aumenta         DESCE aumenta
//40,                        80         ,27,17,		

		//D
		    buttons.add(new Button(1, new Ellipse(13,70,27,17, Color.black, Color.black)));
			buttons.add(new Button(2, new Rect(35,105,20,15, Color.black, Color.black)));
			buttons.add(new Button(3, new Triangulo(50, 160, 25, 27, Color.black, Color.black)));
			buttons.add(new Button(4, new Pentagono(65, 190, 0,0, Color.black, Color.black)));

		
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					

					try{
					FileOutputStream f = new FileOutputStream("proj.bin");
					ObjectOutputStream o = new ObjectOutputStream(f);
					figs.remove(focus);
					o.writeObject(figs);
					o.writeObject(figs);
					o.flush();
					o.close();

				}catch(Exception x){
					System.out.println("ERRO!\n");
				}
					
					
                    System.exit(0);
                }
				
            }
        );
		   
       
            this.addMouseListener (
            new MouseAdapter() {
                 public void mousePressed (MouseEvent evt) {
                    p = getMousePosition();
					
				if(focusB != null ){


					 
							if(focusB.idx==1)
								figs.add(new Ellipse(p.x,p.y,27,17,Color.black,Color.pink));      
							else if(focusB.idx==2)
							{
								
							figs.add(new Rect(p.x,p.y,30,20,Color.black,Color.pink ));      

							}
							else if(focusB.idx==3)
							{
							    figs.add(new Triangulo(p.x,p.y,w,h,Color.black,Color.pink )); 
							}
							else if(focusB.idx==4)
							{
							figs.add(new Pentagono(p.x,p.y,w,h,Color.black,Color.pink ));
							}
							
						focusB.focused = false;
						focusB = null;
						focus=null;
                        repaint();
						return;
				}
					focusB = null;

					
					    for (Button but: buttons) {
                        but.focused = false;
						if (but.contains(evt)) {
                            but.focused = true;
                            focusB = but;
                        }
                    }
					if (focus != null) {
                        focus.corBorda = a;
                    }
					
					 focus=null;
					for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                          focus = fig;
                            a = focus.corBorda;
						
                        }

                    }
					
					
                    if (focus != null) {
						
					// focus.focused=false;
                     focus.corBorda=a;
					if(focus.corBorda != Color.red){
                            focus.corBorda = Color.red;
                        }
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
						 if (focus != null) {
                            if (p != null){
					  Point mousePressedPos=  evt.getPoint();
                      focus.drag(evt.getX() - p.x, evt.getY() - p.y, mousePressedPos);
                      p = getMousePosition();
                      repaint();
							}
                    }
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
						
						
					
					
					}else if(evt.getKeyChar() == 't'){
					
						figs.add(new Triangulo(p.x,p.y,w,h,Color.black,Color.pink )); 
						
						
						
                    
					 }
					 else if(evt.getKeyChar() == 'p'){
					
						figs.add(new Pentagono(p.x,p.y,w,h,Color.black,Color.pink )); 
						
						
						
                    
					 }
					 
				
			     
			/*------------------------------------------------------------------------------
			                         TROCA DE CORES
			  ------------------------------------------------------------------------------*/
			   else if(evt.getKeyChar() == 'w'){

                            focus.colorBorda(Color.green);
							
			   }
			  
			  
			   else if(evt.getKeyChar() == 'z'){

                            focus.colorBorda(Color.blue);
							
			   }else if(evt.getKeyChar() == 'a' && focus!=null ){
	                           
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

				else if (evt.getKeyChar() == '+'   ) { 
				
				
					for(Figure fig: figs){
						if(focus == fig){
					focus.tamanho(1,1);
					
							
						}
					}
					
					
				}
					
					   
				else if (evt.getKeyChar() == '-'   ) {
					
					for(Figure fig: figs){
						if(focus == fig){
							

							focus.tamanho(-1,-1);
                            

							//focus=null;

                         //   figs.remove(focus);
							

								
						}
					}
					
					
					
					
				}
				
				
				  if(evt.getKeyChar() == 'f' ) {
		    		  if(index<figs.size()) {
		    			  focus = figs.get(index);
		    			  index++;
		    		  }
		    		  else {
		    			  index = 0;
		    			  focus = figs.get(index);
		    			  index++;
		    		  }
		      }
				
				/*------------------------------------------------------------
					                REMOVE A FIGURA
				  ------------------------------------------------------------*/
				
				else if(evt.getKeyCode() == KeyEvent.VK_DELETE && focus!=null){
                            figs.remove(focus);
                            focus=null;
                    }
					
					
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
            fig.paint(g, fig.focused);
        }
		
		
		   for (Button but: this.buttons) {
            but.paint(g,but.focused);
        }
		
       
    }
}


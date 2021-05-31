package figures;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible,Serializable {
    public int x, y;
    public int w, h;
	public Color corBorda, cb;
    public boolean focused;

	

    public  Figure (int x, int y, int w, int h, Color corBorda, Color cb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.corBorda=corBorda;
		this.cb=cb;
		this.focused=false;

    }

    public void drag (int dx, int dy, Point p) {
        this.x += dx;
        this.y += dy;
    }
	public void tamanho(int dw,int dh){
		
		this.w+=dw;
		this.h+=dh;

	}

    public abstract boolean contains(MouseEvent evt);
	public abstract void colorFig(Color b);
	public abstract void colorBorda(Color corBorda);

			
		

}

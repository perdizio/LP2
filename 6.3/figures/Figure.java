package figures;

import java.awt.Graphics;

public abstract class Figure {
	int x, y;
	int w, h;
	Color a;
	Color b;	
	
    public abstract void paint (Graphics g);
}

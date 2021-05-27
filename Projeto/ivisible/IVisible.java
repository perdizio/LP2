package ivisible;
import java.awt.Graphics;
import java.awt.event.*;
public interface IVisible{
    public boolean contains(MouseEvent evt);
    public void paint(Graphics g,boolean focused);
}

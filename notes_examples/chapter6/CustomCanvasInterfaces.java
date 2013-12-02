package ee402;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class CustomCanvasInterfaces extends Canvas implements MouseListener{

	int width, height;
	Color drawColor = Color.red;
	Vector<Point> points = new Vector<Point>(10);
	static int radius = 10;
	CounterField callingApp;
	
	public CustomCanvasInterfaces(CounterField app, int width, int height){
		this.setSize(width,height);
		this.width = width;
		this.height = height;
		this.addMouseListener(this);
		this.callingApp = app;
		this.repaint();
	}
		
	public void paint(Graphics g){
		g.setColor(drawColor);
		for(int i=0; i<points.size(); i++){
			Point p = points.elementAt(i);
			g.drawOval(p.x, p.y, 2*radius, 2*radius);
		}
		this.callingApp.setNumber(points.size());
	}
	
	public void setColor(Color c){
		drawColor = c;
		this.repaint();
	}

	public void mouseClicked(MouseEvent e) {
		points.addElement(new Point(e.getX()-radius, e.getY()-radius));
		this.repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}

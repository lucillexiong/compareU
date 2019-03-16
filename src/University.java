/*University.java
 * This class allows the user to enter costs and see the total for their chosen program
 *The back button will lead them back to the menu
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.*;

public class University extends JPanel implements MouseListener{

	private Menu menu;
	
	//Determines if the form was filled
	private boolean filled = false;
	
	private BufferedImage background1, background2;
	
	//Creates a university object
	public University(Menu m) {
		menu = m;
		addMouseListener(this);
		loadImage();		
	}
	
	//Returns true if form is filled, false otherwise
	public boolean getFilled() {
		return filled;
	}
	
	//Loads images for form
	public void loadImage() {
		try {
			background1 = ImageIO.read(new File("form1.png"));
		}
		catch(IOException e) {}
		try {
			background2 = ImageIO.read(new File("form2.png"));
		}
		catch(IOException e) {}
	}
	
	public void paint(Graphics g) {
		//Shows form filled/unfilled
		if(!filled){
			g.drawImage(background1,0,0,404,718,this);
		}
		else {
			g.drawImage(background2,0,0,404,718,this);
		}
	}
	
	//MouseListener
    public void mousePressed(MouseEvent e){
    	if (e.getX()<45 && e.getX()>10 && e.getY()<45 && e.getY()>10){
    		filled = true;
    		menu.getContentPane().remove(this);
    		menu.repaint();
    	}
	}
	
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e){}
	
}

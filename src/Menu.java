/* Menu.java
 * This class allows users to view, add, and compare the post-secondary options they are interested in
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.*;

public class Menu extends JFrame implements MouseListener{
	private BufferedImage background1, background2;
	
	//form user fills out information
	private University uni;
	private boolean filled = false;
	
	//Creates a menu function
	public Menu() {
		super("CompareU");
		setSize(414,736);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//creates a university object
		uni = new University(this);
		addMouseListener(this);
		
		loadImages();
		setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		//Shows menu with number of universities entered
		if (!filled) {
			g.drawImage(background1, 0, 0, 414, 736, this);
		}
		else {
			g.drawImage(background2, 0, 0, 414, 736, this);
		}
	}
	
	//Loads images for menu
	public void loadImages() {
		try {
    		background1 = ImageIO.read(new File("one.png"));
		} 
		catch (IOException e) {
		}
		try{
		    background2 = ImageIO.read(new File("two.png"));
		} 
		catch(IOException e){
		}
	}
	
	//MouseListener
    public void mousePressed(MouseEvent e){
    	//Adds a university to compare
    	//Show university information
    	if (e.getX()<400 && e.getX()>218 && e.getY()<315 && e.getY()>135){
    		if (!filled) {
    			filled = true;
    		}
    		add(uni);
    		uni.repaint();
    		setVisible(true);
    	}
	}
    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}    
    public void mouseClicked(MouseEvent e){} 
    
    public static void main(String [] args) {
    	Menu m = new Menu();
    }
}

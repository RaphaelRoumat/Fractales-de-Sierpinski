package carre;

import java.awt.*;
import java.util.*;
import javax.swing.*;



public class MainFrame extends JPanel
{
	// set window size here
	public static final int WINDOWSIZE = 600;
	
	public static Sierpinski carre;
	 
	public void paint(Graphics g)
	{	
		System.out.println("Paint  = "+ MainFrame.carre.polyList.length );
		
		for(int i = 0; i < MainFrame.carre.polyList.length; i++)
		{
			g.fillPolygon(MainFrame.carre.polyList[i]);
		}
	}
	
	
	public static void main (String[] args)
	{
		// make the base Square based on the window size
		//point 1 -- top left
		int p1x = 0;
		int p1y = 0;	
		//point 2 -- top right
		int p2x = WINDOWSIZE;
		int p2y = 0;
		//point 3 -- bottom right
		int p3x = WINDOWSIZE;
		int p3y = WINDOWSIZE;
		//point 3 -- bottom left
		int p4x = 0;
		int p4y = WINDOWSIZE;
		
		System.out.println("Nombre d'itération: ");
		// ask user how many splits
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  

		int splits = sc.nextInt();  
		
		sc.close();

		// new window
		JFrame f = new JFrame("Sierpinski's Squares!");
		f.setSize(WINDOWSIZE,WINDOWSIZE);
		f.setBackground(Color.white);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MainFrame s = new MainFrame();
		f.add(s);
		// Build a new fractal 
			MainFrame.carre = new Sierpinski(splits);
			carre.computeSquares(splits,p1x,p1y,p2x,p2y,p3x,p3y,p4x, p4y);
		//drawing the squares
		f.setVisible(true);
	}
	 
}

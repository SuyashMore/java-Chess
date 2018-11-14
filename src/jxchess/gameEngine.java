package jxchess;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class gameEngine extends JFrame implements MouseListener {
//	Mouse Controller
	private Vector2 mouse;
	private boolean isSelected=false;
	
//Master gameBoard Variable
	gameBoard board;
	
	graphicsEngine graphics;
	
	
	public gameEngine()
	{
		super("Chess Jx");
		mouse = new Vector2(0,0);
		board = new gameBoard();
		addMouseListener(this);
		graphics = new graphicsEngine(board);
		
		add(graphics);
	}
	
	//Check if it is A Valid Move or Not
	private void transferPiece(int fromX,int fromY,int toX,int toY)
	{
		board.moveContent(fromX,fromY,toX,toY);
		graphics.updateBoard(board);
		graphics.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		//Transform to the Grid Co-ordinate System
		int X = (e.getX() - 48) ; 
		int Y = (e.getY() -80) ;	
		
		
		//Call the Select Function only if the Input is With Limits		
		if(X>=0 && X<=695 && Y>=0 && Y<=701)
		{
			X/=88;
			Y/=85;
			
			if(isSelected==false)
			{
				mouse.x=X;
				mouse.y=Y;
				isSelected=true;
				System.out.print("Selected:");System.out.print(X);System.out.print(",");System.out.println(Y);
			}
			else if(mouse.x!=X || mouse.y!=Y)
			{
				//Call the Transfer Function
				transferPiece(mouse.x,mouse.y,X,Y);
				
				isSelected=false;
				System.out.print("Transferred to:");System.out.print(X);System.out.print(",");System.out.println(Y);
			}
			else
			{
				System.out.print("Already Selected:");System.out.print(X);System.out.print(",");System.out.println(Y);
			}
		}
		
		
		
	}

	//Non Implemented Functions
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

package jxchess;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class graphicsEngine extends JPanel{

//	private JLabel item1;
	BufferedImage img,img2;
	public int WHITE =0,BLACK=1;
	String[] imgFile_w= {"pawn_1.png","rook_1.png","bishop_1.png","knight_1.png","queen_1.png","king_1.png"};
	String[] imgFile_b= {"pawn_2.png","rook_2.png","bishop_2.png","knight_2.png","queen_2.png","king_2.png"};
	String imgChessBoard = "chessBoard.jpg";
	gameBoard referenceBoard;
	
	BufferedImage[] chessmen_w;
	BufferedImage[] chessmen_b;
	BufferedImage chessBoard;
	
	public void paintComponent(Graphics brush)		//SuperClass Overloaded Function
	{
		super.paintComponent(brush);
		drawAll(brush);
	}
	
	
	//Constructor
	public graphicsEngine(gameBoard board)
	{
		updateBoard(board);
		loadGraphics();	//Load All the Graphics Files
		System.out.println("Load Successfull");
	}
	
	public void updateBoard(gameBoard board)
	{
		referenceBoard=board;
	}

	//Draw Chess-men and ChessBoard
	private void drawAll(Graphics brush)
	{
		brush.drawImage(chessBoard, 0, 0, null);
		drawChessMen(brush);
		
	}
	
	
	//Function to Draw the Chess-men on the ChessBoard Depending upon the Location of Each
	//Piece on the Board
	private void drawChessMen(Graphics brush)	
	{
		for(int j=0;j<8;j++)
		{
			for(int i=0;i<8;i++)
			{
				char current =referenceBoard.getElementAt(i,j);
				if(current != referenceBoard.EMPTY_SPACE)
				{
					boolean isBlack = referenceBoard.isElementBlack(current);
					
					int identifier = referenceBoard.getIdOf(current);
					
					int offsetFixx = (j<=4)?52:48;
					int offsetFixy =  (j<=4)?65:80;
					if(isBlack)
						{
							
							brush.drawImage(chessmen_b[identifier], offsetFixx + i*88 , offsetFixy + j*85, null);
						}
					else
						{
							brush.drawImage(chessmen_w[identifier], offsetFixx + i*88 , offsetFixy + j*85, null);
						}
					
				}
					
			}
		}
		
	}
	
	
	//Function to Load All the Images Into the Program
	private void loadGraphics()
	{
		chessmen_w = new BufferedImage[6];
		chessmen_b = new BufferedImage[6];
		//Load all the ChessMen Pieces as Images
		for(int i=0;i<6;i++)
		{
			try 
			{
				chessmen_w[i] = ImageIO.read(new File("Images/"+imgFile_w[i]));
				chessmen_b[i] = ImageIO.read(new File("Images/"+imgFile_b[i]));
				
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		//Load the ChessBoard
		try 
		{
			chessBoard = ImageIO.read(new File("Images/"+imgChessBoard));
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
}

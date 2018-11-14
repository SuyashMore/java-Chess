package jxchess;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class graphicsEngine extends JPanel{

//	private JLabel item1;
	BufferedImage img;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
	
	public graphicsEngine()
	{
		try {
			img = ImageIO.read(new File("Images/chessBoard.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Load Successfull");
		
	}
	
}

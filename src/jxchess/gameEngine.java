package jxchess;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class gameEngine extends JFrame {
	
//	private JLabel item1;
	private graphicsEngine graphics;
	
	public gameEngine()
	{
		super("Chess Jx");
		graphics = new graphicsEngine();
//		setLayout(new FlowLayout());
		add(graphics);
		
		
//		item1 = new JLabel("This is a Sentence");
//		add(img);
		
		
	}
	
	
}

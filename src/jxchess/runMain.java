package jxchess;


import javax.swing.JFrame;

public class runMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		gameBoard g = new gameBoard();
//		g.printDebug();
		
		gameEngine eng = new gameEngine();
		eng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eng.setSize(800,800);
		eng.setVisible(true);
	}

}

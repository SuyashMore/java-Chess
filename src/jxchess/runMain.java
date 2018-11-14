package jxchess;


import javax.swing.JFrame;

public class runMain {

	public static void main(String[] args) {
		
		gameEngine eng = new gameEngine();
		eng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eng.setSize(790,830);
		eng.setVisible(true);
	}

}

package jxchess;

public class gameBoard {
	
//Variable Declarations
	private char[][] Board;
	
	//	Rook,Knight,Bishop,Queen,King,Pawn
	private final char[] BlackChessPieces = {'R','N','B','Q','K','B','N','R','P'};
	private final char[] WhiteChessPieces = {'r','n','b','q','k','b','n','r','p'};
	public final char EMPTY_SPACE = '.';
	
	
//Function Declarations
	gameBoard()		//Constructor
	{
		resetBoard();
	}
	
	public void resetBoard()
	{
//		Initialize Empty Multi-Dim Array
		Board = new char[8][8];
		
		for(int i=0;i<8;i++)
		{
			//Fill in the Black Side
			Board[0][i]=BlackChessPieces[i];	//Primary Chess-men
			Board[1][i]=BlackChessPieces[8];	//All the Pawns
			
			
			//Fill in the White Side
			Board[7][i]=WhiteChessPieces[i];	//Primary Chess-men
			Board[6][i]=WhiteChessPieces[8];	//All the Pawns
			
			//Fill in the Empty Spaces
			for(int j=2;j<6;j++)
			{
				Board[j][i]=EMPTY_SPACE;
			}
		}
		
		
	}
	
	public void moveContent(int fromX,int fromY,int toX,int toY)
	{
		Board[toY][toX] = Board[fromY][fromX];
		Board[fromY][fromX]=EMPTY_SPACE;
		
	}
	
	public char getElementAt(int x,int y)
	{
		return Board[y][x];
	}
	
	public boolean isElementBlack(char in)
	{
		char current = in;
		for(int i=0;i<=8;i++)
		{
			if(current ==BlackChessPieces[i])
			{
				return true;
			}
		}
		return false;
	}
	
	public int getIdOf(char in)
	{
		boolean isBlack = isElementBlack(in);
		if(isBlack)
		{
			switch(in)
			{
			case 'P':
				return 0;
			case 'R':
				return 1;
			case 'N':
				return 2;
			case 'B':
				return 3;
			case 'Q':
				return 4;
			case 'K':
				return 5;
			}
		}
		else
		{
			switch(in)
			{
			case 'p':
				return 0;
			case 'r':
				return 1;
			case 'n':
				return 2;
			case 'b':
				return 3;
			case 'q':
				return 4;
			case 'k':
				return 5;
			}
			
		}
		return 0;
	}
	
	public void printDebug()	//Prints the Entire Board For Debugging Purposes
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(Board[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}

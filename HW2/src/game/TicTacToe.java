package game;

public class TicTacToe extends Game {
	
	public TicTacToe(String player1, String player2){
	//constructor
		super(3, 3,new Player(player1,'X'),new Player(player2,'O'));
	}
	
	@Override
	protected boolean doesWin(int x, int y) 
	//checks if there is a line equals to 3 and return true else false
	{
		if(super.maxLineContaining(x, y) == 3)
			return true;
		else return false;
	}

}

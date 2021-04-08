package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);
	private Player p1, p2;

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		this.p1 = p1;
		this.p2 = p2;
	}

	protected boolean doesWin(int i, int j) {

		if ((i == 0 && j == 0))
			return true;
		else
			return false;
	}

	protected boolean onePlay(Player p) {

		System.out.print(String.format("%s, please enter x and y:", p.toString()));
		int a = s.nextInt();
		int b = s.nextInt();
		
		
		
		 if (isEmpty(a, b)) {
			board[a][b] = p;
			System.out.println(toString());// just for debug (show the graph)
			
		}

		else
		{
			System.out.println("There is a piece there already...");
			onePlay(p); //recursion here
			
		}
	return doesWin(a, b);

	}

	// recursion that goes infinity loop when piece is taken
	// change the option when piece is taken it not changing player
	public Player play() {

		while (isFull() != true) {
			if (onePlay(p1) == true)
				return p1;
			if (onePlay(p2) == true)
				return p2;

		}

		return null;

	}

	public static void main(String[] args) {
		Game g = new Game(3, 4, new Player("Red", 'R'), new Player("Black", 'B'));
//		System.out.println(g.onePlay(g.p1));
		// g.play();
		System.out.println(String.format("%s Won!", g.play()));

	}

}

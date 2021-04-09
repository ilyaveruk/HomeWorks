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
	//check if i and j equals to 0 and return true if it does else false
	protected boolean doesWin(int i, int j) {

		if ((i == 0 && j == 0))
			return true;
		else
			return false;
	}

	protected boolean onePlay(Player p) {
		//asks from the user the space he wants ,sets it and check if the player won
		System.out.print(String.format("%s, please enter x and y:", p.toString()));
		int i = s.nextInt();
		int j = s.nextInt();
		while(this.isEmpty(i, j) == false)
		{
			System.out.println("There is a piece there already");
			System.out.println(String.format("%s, please enter x and y: ",p.toString()));
			i = s.nextInt();
			j = s.nextInt();
		}
		set(i, j, p);
		
		return doesWin(i,j) ;
			
		

	}

	//runs while the board isn't full and call to one play with the wanted player
	public Player play() {

		while (isFull() != true) {
			if (onePlay(p1) == true)
				return p1;
			if (onePlay(p2) == true)
				return p2;

		}

		return null;

	}

	

}

package game;

public class FourInARow extends Game {

	public FourInARow(String player1, String player2)
	// constructor
	{
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	protected boolean doesWin(int i, int j)
	// checks if there is a line equals to 4 and return true else false
	{
		if (super.maxLineContaining(i, j) == 4)
			return true;
		else
			return false;

	}

	@Override
	protected boolean onePlay(Player p)
	// asks from the user which column he wants to play, checks if the column is
	// empty using isColumnfull method,
	// sets it and check if the player won
	{
		System.out.println(p.toString() + ", please enter column: ");
		if (s.hasNextInt()) {
			int i = s.nextInt();
			int j = this.isColumnfull(i);
			while (j == -1 && s.hasNextInt()) {
				System.out.println("These column is full");
				System.out.println(p.toString() + ", please enter column: ");
				i = s.nextInt();
				j = this.isColumnfull(i);
			}
			this.set(i, j, p);
			if (doesWin(i, j) == true)
				return true;
			else
				return false;
		} else
			return false;

	}

	private int isColumnfull(int i)
	// checks if the column isn't full and return the empty raw
	// if the column is full return -1
	{
		if (i >= 6)
			return -1;
		for (int j = 6; j >= 0; j--) {
			if (this.isEmpty(i, j) == true)
				return j;
		}
		return -1;

	}

}

package game;

public class Board {
	protected int n, m;
	protected Player[][] board;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];

	}

	// checks if the board[i][j] is empty if it does it sets player "p" and return
	// true
	// if it doesn't return false
	protected boolean set(int i, int j, Player p) {

		if (board[i][j] == null) {
			board[i][j] = p;
			return true;
		} else
			return false;
	}

	// checks if board[i][j] is equal to null if it does return true else return
	// false
	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null)
			return true;
		else
			return false;
	}

	// checks if board[i][j] isnt empty and return it else return null
	public Player get(int i, int j) {

		if (board[i][j] == null)
			return null;
		else
			return board[i][j];
	}

	// goes over all the matrix "board" and check if there is empty space, if there
	// is return false ,else true
	public boolean isFull() {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j] == null)
					return false;
		return true;
	}

	// makes string out of "board" matrix with the marks of the players
	public String toString() {

		String str = "";
		for (int i = 0; i < n; i++) {
			str += "\n";
			for (int j = 0; j < m; j++)
				if (board[i][j] != null)
					str += board[i][j].getMark();
				else
					str += ".";
		}
		return str;
	}

	private int rayLength(int x, int y, char s1, char s2, char mark) {
		// checks which of the ways to go over and call it self in recursion
		char Mark1;
		if (this.get(x, y) == null)
			return 0;
		Mark1 = this.get(x, y).getMark();
		if (s1 == 'd' && s2 == 'r') {
			if ((x == n - 1 || y == m - 1) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x + 1, y + 1, s1, s2, mark);
			else
				return 0;

		} else if (s1 == 'd' && s2 == 'l') {
			if ((x == n - 1 || y == 0) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x + 1, y - 1, s1, s2, mark);
			else
				return 0;

		} else if (s1 == 'u' && s2 == 'r') {
			if ((x == 0 || y == m - 1) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x - 1, y + 1, s1, s2, mark);
			else
				return 0;

		} else if (s1 == 'u' && s2 == 'l') {
			if ((x == 0 || y == 0) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x - 1, y - 1, s1, s2, mark);
			else
				return 0;

		} else if (s1 == 'u') {
			if ((x == 0) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x - 1, y, s1, s2, mark);
			else
				return 0;

		} else if (s1 == 'd') {
			if ((x == n - 1) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x + 1, y, s1, s2, mark);
			else
				return 0;

		} else if (s2 == 'r') {
			if ((y == m - 1) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x, y + 1, s1, s2, mark);
			else
				return 0;
		} else if (s2 == 'l') {
			if ((y == 0) && (Mark1 == mark))
				return 1;
			else if (Mark1 == mark)
				return 1 + this.rayLength(x, y - 1, s1, s2, mark);
			else
				return 0;
		}
		return 0;
	}

	protected int maxLineContaining(int i, int j) {
		// checks which line is the longest using rayLength
		char s1 = 'x', s2 = 'y', Mark1;
		int k, l, max = 0, temp;
		if (this.get(i, j) == null)
			return 0;
		Mark1 = this.get(i, j).getMark();
		for (k = 0; k < 3; k++) {
			for (l = 0; l < 3; l++) {
				if (k == 0)// down
					s1 = 'd';
				if (k == 1)// up
					s1 = 'u';
				if (l == 0)// left
					s2 = 'l';
				if (l == 1)// right
					s2 = 'r';
				temp = this.rayLength(i, j, s1, s2, Mark1);
				if (temp > max) {
					max = temp;
				}
				s1 = 'x';
				s2 = 'y';
			}
		}
		return max;

	}

}

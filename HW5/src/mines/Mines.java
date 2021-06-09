package mines;

import java.util.Random;

public class Mines {

	private int height, width, numMines;
	private Place[][] board;
	private boolean showAll = false;

	public Mines(int height, int width, int numMines) {
		this.numMines = numMines;
		this.width = width;
		this.height = height;
		board = new Place[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = new Place();
			}
		}
		Random rand = new Random();
		for (int i = 0; i < numMines; i++)
			board[rand.nextInt(height)][rand.nextInt(width)].setMine();
	}

	public class Place
	// Everything described by flags
	{
		private boolean mine = false, open = false, close = true, flag = false;

		public void setMine() {
			mine = true;
		}

		public void setFlag() {
			if (flag == false)
				flag = true;
			else
				flag = false;
		}

		public void openPlace() {
			close = false;
			open = true;
		}

		public boolean getMine() {
			return mine;
		}

		public boolean getClose() {
			return close;
		}

		public boolean getOpen() {
			return open;
		}

		public boolean getFlag() {
			return flag;
		}

	}

	public boolean addMine(int i, int j) {
		if (board[i][j].getMine() == true)
			return false;
		board[i][j].setMine();
		numMines++;
		return true;
	}

	public boolean open(int i, int j) {
		boolean canOpenNeighbors = true;
		if (board[i][j].getMine() == true || board[i][j].getOpen() == true)
			return false;
		board[i][j].openPlace();

		/* checks if one of the Neighbors is a mine */
		if (i + 1 != height)
			if (board[i + 1][j].getMine() == true)
				return true;
		if (i + 1 != height && j + 1 != width)
			if (board[i + 1][j + 1].getMine() == true)
				return true;
		if (i + 1 != height && j != 0)
			if (board[i + 1][j - 1].getMine() == true)
				return true;
		if (j != 0)
			if (board[i][j - 1].getMine() == true)
				return true;
		if (j + 1 != width)
			if (board[i][j + 1].getMine() == true)
				return true;
		if (i != 0)
			if (board[i - 1][j].getMine() == true)
				return true;
		if (i != 0 && j + 1 != width)
			if (board[i - 1][j + 1].getMine() == true)
				return true;
		if (i != 0 && j != 0)
			if (board[i - 1][j - 1].getMine() == true)
				return true;

		/* open the Neighbors */
		if (canOpenNeighbors == true) {
			if (i + 1 != height)
				this.open(i + 1, j);
			if (i + 1 != height && j + 1 != width)
				this.open(i + 1, j + 1);
			if (i + 1 != height && j != 0)
				this.open(i + 1, j - 1);
			if (j != 0)
				this.open(i, j - 1);
			if (j + 1 != width)
				this.open(i, j + 1);
			if (i != 0)
				this.open(i - 1, j);
			if (i != 0 && j + 1 != width)
				this.open(i - 1, j + 1);
			;
			if (i != 0 && j != 0)
				this.open(i - 1, j - 1);
		}
		return true;
	}

	public void toggleFlag(int x, int y) {
		board[x][y].setFlag();
	}

	public boolean isDone() {
		int counter = 0;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (board[i][j].getOpen() == true && board[i][j].getMine() == false)
					counter++;
		if (counter == height * width - numMines)
			return true;
		else
			return false;
	}

	public String get(int i, int j) {
		int numOfMines = 0;
		if (showAll == true) {
			if (board[i][j].getMine() == true)
				return "X";
			numOfMines = checkHowManyMines(i, j);
			if (numOfMines == 0)
				return " ";
			else
				return Integer.toString(numOfMines);

		} else {
			if (board[i][j].getClose() == true)
				if (board[i][j].getFlag() == true)
					return "F";
				else
					return ".";
			if (board[i][j].getOpen() == true)
				if (board[i][j].getMine() == true)
					return "X";
			numOfMines = checkHowManyMines(i, j);
			if (numOfMines == 0)
				return " ";
			else
				return Integer.toString(numOfMines);
		}
	}

	private int checkHowManyMines(int i, int j) {
		int count = 0;
		if (i + 1 != height)
			if (board[i + 1][j].getMine() == true)
				count++;
		if (i + 1 != height && j + 1 != width)
			if (board[i + 1][j + 1].getMine() == true)
				count++;
		if (i + 1 != height && j != 0)
			if (board[i + 1][j - 1].getMine() == true)
				count++;
		if (j != 0)
			if (board[i][j - 1].getMine() == true)
				count++;
		if (j + 1 != width)
			if (board[i][j + 1].getMine() == true)
				count++;
		if (i != 0)
			if (board[i - 1][j].getMine() == true)
				count++;
		if (i != 0 && j + 1 != width)
			if (board[i - 1][j + 1].getMine() == true)
				count++;
		if (i != 0 && j != 0)
			if (board[i - 1][j - 1].getMine() == true)
				count++;
		return count;
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	public String toString() {
		StringBuilder stringToRet = new StringBuilder();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				stringToRet.append(this.get(i, j));
			}
			stringToRet.append("\n");
		}

		return stringToRet.toString();
	}

}

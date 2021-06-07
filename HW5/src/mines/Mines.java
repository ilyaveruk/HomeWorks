package mines;

import java.util.ArrayList;
import java.util.List;

public class Mines {
	private int numMines, height, width, opened = 0;
	private ArrayList<String>[][] board;
	private boolean showAll = false;

	public Mines(int height, int width, int numMines) {
		Single s = new Single();
		this.height = height;
		this.width = width;
		board = new ArrayList[height][width]; // Create game board.
		for (int i = 0; i < height; i++) // Initialize game board
			for (int j = 0; j < width; j++) {
				board[i][j] = (s.singleMethod(height, width, i, j));// Set status of each slot
				board[i][j].addAll(s.getNeighbors(i, j)); // add all neighbors

				// 0-mines 1-open 2-flag 3-Close Mines 4-Revealed 5-12-neighbors//
			}

		this.numMines = numMines;

	}

	private class Single {
		private int height, width;

		ArrayList<String> singleMethod(int height, int width, int i, int j) {
			this.height = height;
			this.width = width;
			board[i][j] = new ArrayList<String>(4);
			board[i][j].add("Flaged=0");
			board[i][j].add("Mined=0");
			board[i][j].add("Open=0");
			board[i][j].add("Close Mines=0");
			board[i][j].add("Revealed=0");
			return board[i][j];
		}

		List<Integer> nearMines(int height, int width, int i, int j) {
			List<Integer> list = new ArrayList<Integer>();
			{
				if (j + 1 < width)
					if (board[i][j + 1] != null)
						if (board[i][j + 1].contains("Mined=1"))
							list.add(1);
				if (i != 0)
					if (board[i - 1][j] != null)
						if (board[i - 1][j].contains("Mined=1"))
							list.add(1);
				if (j != 0)
					if (board[i][j - 1] != null)
						if (board[i][j - 1].contains("Mined=1"))
							list.add(1);
				if (i + 1 < height)
					if (board[i + 1][j] != null)
						if (board[i + 1][j].contains("Mined=1"))
							list.add(1);
				if (i != 0 && j + 1 < width)
					if (board[i - 1][j + 1] != null)
						if (board[i - 1][j + 1].contains("Mined=1"))
							list.add(1);
				if (i != 0 && j != 0)
					if (board[i - 1][j - 1] != null)
						if (board[i - 1][j - 1].contains("Mined=1"))
							list.add(1);
				if (i + 1 < height && j + 1 < width)
					if (board[i + 1][j + 1] != null)
						if (board[i + 1][j + 1].contains("Mined=1"))
							list.add(1);
				if (j != 0 && i + 1 < height)
					if (board[i + 1][j - 1] != null)
						if (board[i + 1][j - 1].contains("Mined=1"))
							list.add(1);

			}
			return list;
		}

		public List<String> getNeighbors(int i, int j) {
			List<String> neighbors = new ArrayList<String>();
			neighbors.add(0, Integer.toString(i) + Integer.toString(j + 1));
			neighbors.add(1, Integer.toString(i) + Integer.toString(j - 1));
			neighbors.add(2, Integer.toString(i + 1) + Integer.toString(j + 1));
			neighbors.add(3, Integer.toString(i + 1) + Integer.toString(j));
			neighbors.add(4, Integer.toString(i + 1) + Integer.toString(j - 1));
			neighbors.add(5, Integer.toString(i - 1) + Integer.toString(j));
			neighbors.add(6, Integer.toString(i - 1) + Integer.toString(j + 1));
			neighbors.add(7, Integer.toString(i - 1) + Integer.toString(j - 1));
			return neighbors;

		}

	}

	public boolean addMine(int i, int j) {
		Single s = new Single();
		String str = null;
		numMines++;
		board[i][j].set(1, "Mined=1"); // Once mine is added,Board is updated
		for (int k = 0; k < this.height; k++)
			for (int l = 0; l < this.width; l++) {
				str = String.format("%s%d", "Close Mines=", s.nearMines(height, width, k, l).size());
				board[k][l].set(3, str); // Set how many mines are next to the slot
			}
		return true;
	}

	public boolean open(int i, int j) {
		if (i < 0 || i == height || j < 0 || j == width)
			return false;
		if (board[i][j].contains("Mined=1")) {
			showAll=true;
			return false;
		}
		if (board[i][j].contains("Mined=0")) {
			if (board[i][j].contains("Open=0")) {
				opened++;
				board[i][j].set(2, "Open=1");
			}
		}
		if (board[i][j].contains("Close Mines=0") && board[i][j].contains("Revealed=0")) {
			board[i][j].set(2, "Open=1");
			if (board[i][j].contains("Open=0"))
				opened++;
			board[i][j].set(4, "Revealed=1");
			openNeighbors(i, j);
		} else
			return false;
		open(i + 1, j);
		open(i - 1, j);
		open(i, j - 1);
		open(i, j + 1);
		return true;
	}

	public boolean openNeighbors(int i, int j) {
		for (int c = 5; c < board[i][j].size(); c++) {
			String str;
			char e, d;
			int a, b;
			str = board[i][j].get(c).toString();
			e = str.charAt(0);
			d = str.charAt(1);
			a = Character.getNumericValue(e);
			b = Character.getNumericValue(d);
			if (a >= 0 && b >= 0 && a <= height - 1 && b <= width - 1) {
				if (board[a][b].contains("Open=0"))
					opened++;
				board[a][b].set(2, "Open=1");
			}
		}
		return false;
	}

	public void toggleFlag(int x, int y) {
		if (board[x][y].contains("Flaged=1"))
			board[x][y].set(0, "Flaged=0");
		else
			board[x][y].set(0, "Flaged=1");
	}

	public boolean isDone() {
		int surface = this.height * this.width;
		if ((surface - opened) == numMines)
			return true;
		else
			return false;
	}

	public String get(int i, int j) {
		if (showAll) {
			if (board[i][j].contains("Flaged=1"))
				return "F";
			else if (board[i][j].contains("Mined=1"))
				return "X";
			else if (board[i][j].contains("Close Mines=0"))
				return " ";
			else
				return board[i][j].get(3).substring(12, 13);
		}
		if (board[i][j].contains("Open=0"))
			if (board[i][j].contains("Flaged=1"))
				return "F";
			else
				return ".";
		else if (board[i][j].contains("Mined=1"))
			return "X";
		else if (board[i][j].contains("Close Mines=0"))
			return " ";
		else
			return board[i][j].get(3).substring(12, 13);
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++) {
				str += this.get(i, j);
				if (j == width - 1)
					str += "\n";
			}
		return str;
	}
}

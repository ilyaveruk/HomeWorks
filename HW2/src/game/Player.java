package game;

public class Player {
	private String name;
	private char mark;

	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	// returns the name of the player
	public String getName() {
		return name;
	}

	// return the mark of the player
	public char getMark() {
		return mark;
	}

	// converts to string and prints it
	public String toString() {
		return String.format("%s(%c)", name, mark);
	}

}

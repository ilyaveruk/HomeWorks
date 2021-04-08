package cards;

public class Card {
	private int num;
	private int suit;
	private String dict[] = { "C", "D", "H", "S" };

	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}

	public int getNum() {
		return num;
	}

	public int getSuit() {
		return suit;
	}

	public String toString() {
		return num + dict[suit];
	}

	public int compareTo(Card other) {

		if (this.getNum() == other.getNum()) {
			if(this.getSuit() == other.getSuit())
				return 0;
			else if (this.getSuit()>other.getSuit())
				return 1;
			else return -1;
		}
		
		if(this.getNum() > other.getNum())
			return 1;
		else 
			return -1;
	}
}

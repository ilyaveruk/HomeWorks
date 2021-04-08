package cards;

public class Deck {
	private Card[] DeckOfCard;
	private Card tempCard;
	private int count, numOfCards;

	public Deck(int num) {
		DeckOfCard = new Card[num * 4];
		numOfCards = num * 4;

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 4; j++) {
				Card card = new Card(i, j);
				DeckOfCard[count++] = card;
			}
		}

	}

	public Deck(Deck from, int num) {

		if (num >= from.getNumCards())
			numOfCards = from.getNumCards();
		else
			numOfCards = num;
		DeckOfCard = new Card[numOfCards];
		for (int i = 0; i < numOfCards; i++)
			DeckOfCard[i] = from.takeOne();

	}

	public Deck(Deck first, Deck second) {
		count = first.getNumCards() + second.getNumCards();
		numOfCards = count;
		DeckOfCard = new Card[numOfCards];

		for (int i = 0; i < count; i++) {
			if ((first.getNumCards() > 0) && (second.getNumCards() > 0)) {
				DeckOfCard[i++] = first.takeOne();
				DeckOfCard[i] = second.takeOne();
			} else if ((first.getNumCards() > 0) && (second.getNumCards() <= 0)) {
				DeckOfCard[i] = first.takeOne();
			} else if ((first.getNumCards() <= 0) && (second.getNumCards() > 0)) {
				DeckOfCard[i] = second.takeOne();
			}
		}
	}

	public int getNumCards() {
		return numOfCards;
	}

	public Card takeOne() {
		if (numOfCards == 0)
			return null;

		else {
			numOfCards--;
			tempCard = DeckOfCard[numOfCards];
			DeckOfCard[numOfCards] = null;
			return tempCard;
		}

	}

	public String toString() {

		String str = "[";
		if (numOfCards == 0)
			return "[]";
		else {
			for (int i = 0; i < numOfCards - 1; i++)
				str = str + DeckOfCard[i].toString() + ", ";

			return str + DeckOfCard[numOfCards - 1].toString() + "]";
		}
	}

	public void sort() {

		for (int i = 0; i < numOfCards - 1; i++)
			for (int j = 0; j < numOfCards - i - 1; j++) {
				if (DeckOfCard[j].getNum() > DeckOfCard[j + 1].getNum()) {
					tempCard = DeckOfCard[j];
					DeckOfCard[j] = DeckOfCard[j + 1];
					DeckOfCard[j + 1] = tempCard;
				} else if (DeckOfCard[j].getNum() == DeckOfCard[j + 1].getNum()) {
					if (DeckOfCard[j].getSuit() > DeckOfCard[j + 1].getSuit()) {
						tempCard = DeckOfCard[j];
						DeckOfCard[j] = DeckOfCard[j + 1];
						DeckOfCard[j + 1] = tempCard;
					}
				}

			}

	}

}

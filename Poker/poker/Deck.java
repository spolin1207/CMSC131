package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		int suit, cardInSuit;
		int count = 0;
		
		
		//Creates a deck with 52 cards
		cards = new Card[52];

		for (suit = 0; suit <= 3; suit++) {
			for (cardInSuit = 1; cardInSuit <= 13; cardInSuit++) {
				cards[count] = new Card(cardInSuit, suit);
				count++;
			}
		}
	}

	public Deck(Deck other) {
		this.cards = other.cards;
	}

	public Card getCardAt(int position) {
		return cards[position];
	}

	public int getNumCards() {
		return cards.length;
	}

	public void shuffle() {
		int counter = 0;
		int counter1 = 0;
		int counter2 = 0;
		Card[] upper, lower;
		
		//Breaks cards into two halves based on whether there are an odd or even number
		if (cards.length % 2 == 0) {
			upper = new Card[cards.length / 2];
			lower = new Card[cards.length / 2];
		} else {
			upper = new Card[((cards.length - 1) / 2) + 1];
			lower = new Card[(cards.length - 1) / 2];
		}

		for (int i = 0; i < upper.length; i++) {
			upper[i] = cards[i];
			counter++;
		}
		for (int i = 0; i < lower.length; i++) {
			lower[i] = cards[counter];
			counter++;
		}
		//Reassigns new values to the original cards array
		for (int i = 0; i < cards.length; i++) {
			if (i % 2 == 0) {
				cards[i] = upper[counter1];
				counter1++;
			} else {
				cards[i] = lower[counter2];
				counter2++;
			}

		}

	}

	public void cut(int position) {
		int counter = 0;
		int counter2 = 0;

		Card[] firstcut = new Card[position];
		Card[] secondcut = new Card[cards.length - position];

		// Create two arrays with the cut
		for (int i = 0; i < cards.length; i++) {
			if (i < position) {
				firstcut[i] = cards[i];
			} else {
				secondcut[counter] = cards[i];
				counter++;
			}
		}

		// Set new values to the cards array
		for (int j = 0; j < cards.length; j++) {
			if (j < counter) {
				cards[j] = secondcut[j];
			} else {
				cards[j] = firstcut[counter2];
				counter2++;
			}
		}

	}

	public Card[] deal(int numCards) {
		Card[] smaller = new Card[cards.length - numCards];
		Card[] deal = new Card[numCards];

		int counter = 0;
		
		//Creates an array to return the cards that are dealt
		for (int i = 0; i < cards.length; i++) {
			if (i < numCards) {
				deal[i] = cards[i];
			} else {
				smaller[counter] = cards[i];
				counter++;
			}
		}

		this.cards = smaller;

		return deal;
	}

}

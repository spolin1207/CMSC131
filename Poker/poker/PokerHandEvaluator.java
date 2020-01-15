package poker;

public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {

		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean hasTwoPair(Card[] cards) {

		//Increments through every single card, and uses multiple if statements to check the possible two pair occurences	
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					for (int l = k + 1; l < cards.length; l++) {
						for (int m = l + 1; m < cards.length; m++) {
							if (cards[i].getValue() == cards[j].getValue()
									&& cards[k].getValue() == cards[l].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[k].getValue()
									&& cards[j].getValue() == cards[l].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[l].getValue()
									&& cards[k].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[l].getValue()
									&& cards[k].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[l].getValue()
									&& cards[k].getValue() == cards[i].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[l].getValue()
									&& cards[i].getValue() == cards[k].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[k].getValue()
									&& cards[i].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[k].getValue()
									&& cards[l].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[k].getValue()
									&& cards[l].getValue() == cards[i].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[j].getValue()
									&& cards[k].getValue() == cards[i].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[j].getValue()
									&& cards[k].getValue() == cards[l].getValue()) {
								return true;
							}
							if (cards[m].getValue() == cards[j].getValue()
									&& cards[l].getValue() == cards[i].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[m].getValue()
									&& cards[k].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[m].getValue()
									&& cards[l].getValue() == cards[j].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[m].getValue()
									&& cards[k].getValue() == cards[l].getValue()) {
								return true;
							}
							if (cards[i].getValue() == cards[j].getValue() && cards[m].getValue() == cards[l].getValue()) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {

		//Increments through every single card in the array until it finds three that match up to each other
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					if (cards[i].getValue() == cards[j].getValue() && cards[j].getValue() == cards[k].getValue()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean hasStraight(Card[] cards) {
		int maxVal = -1;
		int a = -1;
		int minVal = 13;
		int counter = 0;

		//Finds max value of the array
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() > maxVal) {
				a = i;
				maxVal = cards[i].getValue();
			}
		}

		//Finds minimum value of the array
		for (int j = 0; j < cards.length; j++) {
			if (cards[j].getValue() < minVal) {
				minVal = cards[j].getValue();

			}
		}
		
		//Account for if an ace is in the straight
		if (minVal == 1) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() >= 10) {
					maxVal = 14;
					counter++;
				}
			}
		}
		//A straight exist if the difference between the highest and lowest cards are 4, and no duplicates exist
		if (maxVal - minVal == 4 && hasPair(cards) == false) {
			return true;
		}

		return false;
	}

	public static boolean hasFlush(Card[] cards) {
		//Finds the suit of the first card
		int suit = cards[0].getSuit();
		int numberOfFlush = 0;

		//Increments through all the other cards to see if they are the same suit
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getSuit() == suit) {
				numberOfFlush++;
			}
		}
		
		//If 5 total cards are found to be flush, then there is a flush
		if (numberOfFlush == 4) {
			return true;
		}

		return false;
	}

	public static boolean hasFullHouse(Card[] cards) {
		if (hasThreeOfAKind(cards) == true && hasTwoPair(cards) == true) {
			return true;
		}
		return false;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		//Increments through every single card in every single position until 4 matches are found
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					for (int l = k + 1; l < cards.length; l++) {
						if (cards[i].getValue() == cards[j].getValue() && cards[j].getValue() == cards[k].getValue() && cards[k].getValue() == cards[l].getValue()) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		if (hasFlush(cards) == true && hasStraight(cards) == true) {
			return true;
		}
		return false;
	}
}

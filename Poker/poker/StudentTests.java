package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void test1() {
		Card[] testPair = { new Card(9, 2), new Card(12, 3), new Card(4, 0), new Card(12, 2), new Card(1, 1) };
		boolean expected = true;

		boolean answer = PokerHandEvaluator.hasPair(testPair);
		assertEquals(answer, expected);

	}

	@Test
	public void test2() {
		Card[] testTwoPair = { new Card(9, 2), new Card(12, 3), new Card(9, 0), new Card(1, 2), new Card(12, 1) };
		Card[] testTwoPair2 = { new Card(1, 2), new Card(9, 3), new Card(9, 0), new Card(12, 2), new Card(12, 1) };
		Card[] testTwoPair3 = { new Card(1, 2), new Card(1, 3), new Card(9, 0), new Card(12, 2), new Card(12, 1) };
		Card[] testTwoPair4 = { new Card(1, 2), new Card(1, 3), new Card(12, 0), new Card(12, 2), new Card(9, 1) };
		Card[] testTwoPair5 = { new Card(9, 2), new Card(12, 3), new Card(9, 0), new Card(12, 2), new Card(1, 1) };

		boolean answer = PokerHandEvaluator.hasTwoPair(testTwoPair);
		boolean answer2 = PokerHandEvaluator.hasTwoPair(testTwoPair2);
		boolean answer3 = PokerHandEvaluator.hasTwoPair(testTwoPair3);
		boolean answer4 = PokerHandEvaluator.hasTwoPair(testTwoPair4);
		boolean answer5 = PokerHandEvaluator.hasTwoPair(testTwoPair5);

		assertTrue(answer);
		assertTrue(answer2);
		assertTrue(answer3);
		assertTrue(answer4);
		assertTrue(answer5);
	}

	@Test
	public void test3() {
		Card[] testThreePair = { new Card(9, 2), new Card(12, 3), new Card(4, 0), new Card(9, 2), new Card(9, 1) };
		boolean expected = true;

		boolean answer = PokerHandEvaluator.hasThreeOfAKind(testThreePair);
		assertEquals(answer, expected);

	}

	@Test
	public void test4() {
		Card[] testStraight = { new Card(8, 2), new Card(9, 3), new Card(10, 0), new Card(11, 2), new Card(12, 1) };

		boolean answer = PokerHandEvaluator.hasStraight(testStraight);
		assertTrue(answer);

	}

	@Test
	public void test5() {
		Card[] testFlush = { new Card(3, 2), new Card(7, 2), new Card(4, 2), new Card(12, 2), new Card(1, 2) };
		boolean expected = true;

		boolean answer = PokerHandEvaluator.hasFlush(testFlush);
		assertEquals(answer, expected);

	}

	@Test
	public void test6() {
		Card[] testFullHouse = { new Card(9, 2), new Card(9, 3), new Card(4, 0), new Card(4, 2), new Card(9, 1) };

		boolean answer = PokerHandEvaluator.hasFullHouse(testFullHouse);
		assertTrue(answer);

	}

	@Test
	public void test7() {
		Card[] testFourOfAKind = { new Card(9, 2), new Card(9, 3), new Card(4, 0), new Card(9, 2), new Card(1, 1) };
		Card[] testFourOfAKind1 = { new Card(9, 2), new Card(9, 3), new Card(4, 0), new Card(9, 2), new Card(9, 1) };

		boolean answer = PokerHandEvaluator.hasFourOfAKind(testFourOfAKind);
		boolean answer1 = PokerHandEvaluator.hasFourOfAKind(testFourOfAKind1);

		assertFalse(answer);
		assertTrue(answer1);
	}

	@Test
	public void test8() {
		Card[] testStraightFlush = { new Card(2, 2), new Card(3, 2), new Card(4, 2), new Card(5, 2), new Card(6, 2) };

		boolean answer = PokerHandEvaluator.hasStraightFlush(testStraightFlush);

		assertTrue(answer);
	}
}
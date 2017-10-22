package com.tdd.tic_tac_toe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

/**
 * Unit test for TicTacToe.
 */
public class TicTacToeSpec {
	/**
	 * Specification 1 : A piece can be placed on any empty space of a 3×3 board.
	 * Specification 2 : There should be a way to find out which player should play
	 * next.
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	private TicTacToe ticTacToe;

	@Before
	public void before() {
		ticTacToe = new TicTacToe();
	}

	/**
	 * Test Requirement for Specification 1 : When a piece is placed anywhere
	 * outside the X axis, then RuntimeException is thrown.
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenXOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(4, 2);
	}

	/**
	 * Test Requirement for Specification 1 : When a piece is placed anywhere
	 * outside the Y axis, then RuntimeException is thrown.
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 4);
	}

	/**
	 * Test Requirement for Specification 1 : When a piece is placed on an occupied
	 * space, then RuntimeException is thrown.
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenBoxNotFreeThenRuntimeException() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 1);
	}

	/**
	 * Test Requirement for Specification 2 : The first turn should be played by
	 * played X
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void givenFirstTurnWhenNextPlayerThenX() {
		Assert.assertEquals('X', ticTacToe.nextPlayer());
	}

	/**
	 * Test Requirement for Specification 2 : If the last turn was played by X, then
	 * the next turn should be played by O
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void givenLastTurnWasXWhenNextPlayerThenO() {
		ticTacToe.play(1, 1);
		Assert.assertEquals('O', ticTacToe.nextPlayer());
	}

	/**
	 * Test Requirement for Specification 2 : If the last turn was played by O, then
	 * the next turn should be played by X
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void givenLastTurnWasYWhenNextPlayerThenX() {
		ticTacToe.play(1, 1);
		ticTacToe.play(2, 1);
		Assert.assertEquals('X', ticTacToe.nextPlayer());
	}
}

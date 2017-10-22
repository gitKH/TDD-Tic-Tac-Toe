package com.tdd.tic_tac_toe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for TicTacToe.
 */
public class TicTacToeSpec {
	/**
	 * Specification 1 : A piece can be placed on any empty space of a 3×3 board.
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
}

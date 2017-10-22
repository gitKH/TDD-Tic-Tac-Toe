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
	 * 
	 * Specification 2 : There should be a way to find out which player should play
	 * next.
	 * 
	 * Specification 3 : A player wins by being the first to connect a line of
	 * friendly pieces from one side or corner of the board to the other. next.
	 * 
	 * Specification 4 : The result is a draw when all the boxes are filled.
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

	/**
	 * Test Requirement for Specification 3 : Until a winner occurred, print no
	 * winner
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenPlayThenNoWinner() {
		String actual = ticTacToe.play(1, 1);
		Assert.assertEquals("No winner", actual);
	}

	/**
	 * Test Requirement for Specification 3 : Check if the horizontal lines are
	 * completed in order to finish the game and announce a winner
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenPlayAndWholeHorizontalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 2); // O
		String actual = ticTacToe.play(3, 1); // X
		Assert.assertEquals("X is the winner", actual);
	}

	/**
	 * Test Requirement for Specification 3 : Check if the vertical lines are
	 * completed in order to finish the game and announce a winner
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenPlayAndWholeVerticalLineThenWinner() {
		ticTacToe.play(2, 1); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(3, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		String actual = ticTacToe.play(1, 3); // O
		Assert.assertEquals("O is the winner", actual);
	}

	/**
	 * Test Requirement for Specification 3 : Check if the bottom diagonal lines are
	 * completed in order to finish the game and announce a winner
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenPlayAndTopBottomDiagonalLineThenWinner() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 3); // O
		String actual = ticTacToe.play(3, 3); // O
		Assert.assertEquals("X is the winner", actual);
	}

	/**
	 * Test Requirement for Specification 3 : Check if the top diagonal lines are
	 * completed in order to finish the game and announce a winner
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenPlayAndBottomTopDiagonalLineThenWinner() {
		ticTacToe.play(1, 3); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 2); // O
		String actual = ticTacToe.play(3, 1); // O
		Assert.assertEquals("X is the winner", actual);
	}

	/**
	 * Test Requirement for Specification 4 : Check if all boxes are
	 * completed in order to finish the game and announce a draw
	 *
	 * @param None
	 * @return Nothing
	 */
	@Test
	public void whenAllBoxesAreFilledThenDraw() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(3, 2);
		Assert.assertEquals("The result is draw", actual);
	}
}

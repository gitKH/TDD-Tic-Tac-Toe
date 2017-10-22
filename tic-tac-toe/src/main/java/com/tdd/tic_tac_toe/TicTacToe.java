package com.tdd.tic_tac_toe;

public class TicTacToe {
	private Character[][] ticTacToeBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };

	public void play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		setXInBox(x, y);
	}
	
	public void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("X is outside of board");
		} 
	}
	
	public void setXInBox(int x, int y) {
		if (ticTacToeBoard[x-1][y-1] != '\0') {
			throw new RuntimeException("Box is not free for playing");
		}
		else {
			ticTacToeBoard[x-1][y-1] = 'X';
		}
	}

	public static void main(String[] args) {

	}
}

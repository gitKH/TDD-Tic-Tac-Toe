package com.tdd.tic_tac_toe;

public class TicTacToe {
	private Character[][] ticTacToeBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private final int SIZE = 3;
	private char lastPlayer = '\0';

	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setXInBox(x, y, lastPlayer);
		for (int index = 0; index < 3; index++) {
			if (isWin()) {
				return lastPlayer + " is the winner";
			}
		}
		return "No winner";
	}

	public void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("X is outside of board");
		}
	}

	public void setXInBox(int x, int y, char lastplayer) {
		if (ticTacToeBoard[x - 1][y - 1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			ticTacToeBoard[x - 1][y - 1] = lastPlayer;
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

	private boolean isWin() {
		int playerTotal = lastPlayer * 3;
		for (int i = 0; i < SIZE; i++) {
			if (ticTacToeBoard[0][i] + ticTacToeBoard[1][i] + ticTacToeBoard[2][i] == playerTotal) {
				return true;
			} else if (ticTacToeBoard[i][0] + ticTacToeBoard[i][1] + ticTacToeBoard[i][2] == playerTotal) {
				return true;
			} else if ((ticTacToeBoard[0][0] + ticTacToeBoard[1][1] + ticTacToeBoard[2][2]) == playerTotal) {
				return true;
			} else if ((ticTacToeBoard[0][2] + ticTacToeBoard[1][1] +
					ticTacToeBoard[2][0]) == playerTotal) {
				return true;
				}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}

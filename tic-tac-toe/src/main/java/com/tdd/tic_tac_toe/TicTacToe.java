package com.tdd.tic_tac_toe;

public class TicTacToe {
	private Character[][] ticTacToeBoard = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private final int SIZE = 3;
	private char lastPlayer = '\0';

	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setInBox(x, y, lastPlayer);
		if (isWin(x,y)) {
			return lastPlayer + " is the winner";
		} else if (isDraw()) {
			return "The result is draw";
		} else {
			return "No winner";
		}
	}

	private boolean isDraw() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (ticTacToeBoard[x][y] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	public void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("X is outside of board");
		}
	}

	public void setInBox(int x, int y, char lastplayer) {
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

	private boolean isWin(int x, int y) {
		int playerTotal = lastPlayer * 3;
		char horizontal, vertical, diagonal1, diagonal2;
		horizontal = vertical = diagonal1 = diagonal2 = '\0';
		for (int i = 0; i < SIZE; i++) {
			horizontal += ticTacToeBoard[i][y - 1];
			vertical += ticTacToeBoard[x - 1][i];
			diagonal1 += ticTacToeBoard[i][i];
			diagonal2 += ticTacToeBoard[i][SIZE - i - 1];
		}
		if (horizontal == playerTotal || vertical == playerTotal || diagonal1 == playerTotal
				|| diagonal2 == playerTotal) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		
		System.out.println(ticTacToe.play(1, 1));
		System.out.println(ticTacToe.play(1, 2));
		System.out.println(ticTacToe.play(1, 3));
		System.out.println(ticTacToe.play(2, 3));
		System.out.println(ticTacToe.play(2, 2));
		System.out.println(ticTacToe.play(3, 1));
		System.out.println(ticTacToe.play(3, 3));
	}
}

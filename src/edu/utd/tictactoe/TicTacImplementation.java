package edu.utd.tictactoe;

public class TicTacImplementation {

	private char[][] board = new char[3][3];
	char currentPlayer;

	TicTacImplementation() {
	};

	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			// Loop through columns
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	public void printBoard1() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public boolean isBoardFull() {
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'x' || board[i][j] == 'o') {
					ans++;
				}
			}
		}
		if (ans == 9)
			return true;
		else
			return false;
	}

	public boolean isWinner() {
		return (checkRows() || checkColumns() || checkDiagonals());
	};

	private boolean checkRows() {
		boolean ans = false;
		for (int i = 0; i < 3; i++)
			if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true)
				ans = true;
		return ans;
	}

	public boolean checkColumns() {
		boolean ans = false;
		for (int i = 0; i < 3; i++)
			if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
				ans = true;
		return ans;
	}

	public boolean checkDiagonals() {

		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));

	}

	private boolean checkRowCol(char c1, char c2, char c3) {
		return (((c1 == 'x') && (c1 == c2) && (c2 == c3)) || ((c1 == 'o') && (c1 == c2) && (c2 == c3)));

	}

	public void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		} else {
			currentPlayer = 'x';
		}
	}

	public void placeMark(int row, int col) {
		boolean ans = false;
		if ((row >= 0) && (row < 3) && (col >= 0) && (col < 3)) {
			if (board[row][col] != 'x' && board[row][col] != 'o') {
				board[row][col] = currentPlayer;
				printBoard1();

			} else {
				System.out.println("Please select some other point");
			}
		} else
			changePlayer();
	}

}

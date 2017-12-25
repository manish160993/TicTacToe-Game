package edu.utd.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		TicTacImplementation game = new TicTacImplementation();
		game.printBoard1();
		game.currentPlayer = 'x';
		Scanner scan = new Scanner(System.in);
		while (!game.isBoardFull() && !game.isWinner()) {
			game.changePlayer();
			System.out.println("Please provide your inputs");
			int x = scan.nextInt();
			int y = scan.nextInt();
			game.placeMark(x, y);
		}
		if (game.isWinner())
			System.out.println("Player " + game.currentPlayer + " wins");
		else
			System.out.println("Tie");
	}
}

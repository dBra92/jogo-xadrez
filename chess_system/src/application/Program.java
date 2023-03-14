package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScrean();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source:");
				ChessPosition source = UI.readChessPosition(read);

				System.out.println();

				System.out.print("Target:");
				ChessPosition target = UI.readChessPosition(read);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException ce) {
				System.out.println(ce.getMessage());
				read.nextLine();
			} catch (InputMismatchException ie) {
				System.out.println(ie.getMessage());
				read.nextLine();
			}
		}
	}

}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMove() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		// Acima
		Position position = new Position(0, 0);

		position.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setRow(position.getRow() - 1);
		}

		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// Esquerda
		position.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() - 1);
		}

		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// Direita
		position.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() + 1);
		}

		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		// Pra baixo - below
		position.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() + 1);
		}

		if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		return mat;
	}

}

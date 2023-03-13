package chess;

import boardgame.Position;

public class ChessPosition {

	private int row;
	private char colum;

	public ChessPosition(char colum, int row) {
		if (colum < 'a' || colum > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8");
		}
		this.row = row;
		this.colum = colum;
	}

	public int getRow() {
		return row;
	}

	public char getColum() {
		return colum;
	}

	protected Position toPosition() {
		return new Position(8 - row, colum - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
}

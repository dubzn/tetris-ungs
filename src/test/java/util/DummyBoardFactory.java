package util;

import java.util.List;

import exceptions.SquareNotFoundException;
import models.Square;
import models.Orientation;
import models.Tetromino;
import models.Position;
import models.Board;

public class DummyBoardFactory {
	
	public static Board create() {
		return new Board();
	}
	
	public static Board addTetromino(Board tablero, Position position, Tetromino tetromino) throws SquareNotFoundException {
		tablero.getSquare(position.getX(), position.getY());
		
		List<Square> squares = tetromino.getState().getOrientation().equals(Orientation.HORIZONTAL) ? tetromino.getHorizontalForm() : tetromino.getVerticalForm();
		
		for(Square square : squares) {
			tablero.getSquare(position.getX() + square.getX(), position.getY() + square.getY()).setOccupied(true);
		}
		
		return tablero;
	}
	
	public static Board withPieza(Position position, Tetromino pieza) throws SquareNotFoundException {
		Board board = new Board();
		
		board.getSquare(position.getX(), position.getY());
		
		List<Square> squares = pieza.getState().getOrientation().equals(Orientation.HORIZONTAL) ? pieza.getHorizontalForm() : pieza.getVerticalForm();
		
		for(Square square : squares) {
			board.getSquare(position.getX() + square.getX(), position.getY() + square.getY()).setOccupied(true);
		}
		
		return board;
	}
	
	public static Board create(List<Integer> occupiedLines) {
		Board board = new Board();
		for(Square square : board.getSquares()) {
			if(occupiedLines.contains(square.getY())) {
				square.setOccupied(true);
			}
		}
		return board;
	}

}

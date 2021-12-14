package util;

import java.util.List;

import exception.SquareNotFoundException;
import model.Square;
import model.Orientation;
import model.Tetromino;
import model.Position;
import model.Board;

public class DummyTableroFactory {
	
	public static Board create() {
		return new Board();
	}
	
	
	public static Board addPieza(Board tablero, Position position, Tetromino pieza) throws SquareNotFoundException {
		tablero.getSquare(position.getX(), position.getY());
		
		List<Square> celdasPieza = pieza.getState().getOrientation().equals(Orientation.HORIZONTAL) ? pieza.getHorizontalForm() : pieza.getVerticalForm();
		
		for(Square celda : celdasPieza) {
			tablero.getSquare(position.getX() + celda.getX(), position.getY() + celda.getY()).setOccupied(true);
		}
		
		return tablero;
	}
	
	public static Board withPieza(Position position, Tetromino pieza) throws SquareNotFoundException {
		Board tablero = new Board();
		
		tablero.getSquare(position.getX(), position.getY());
		
		List<Square> celdasPieza = pieza.getState().getOrientation().equals(Orientation.HORIZONTAL) ? pieza.getHorizontalForm() : pieza.getVerticalForm();
		
		for(Square celda : celdasPieza) {
			tablero.getSquare(position.getX() + celda.getX(), position.getY() + celda.getY()).setOccupied(true);
		}
		
		return tablero;
	}
	
	public static Board create(List<Integer> lineasOcupadas) {
		Board tablero = new Board();
		
		for(Square celda : tablero.getAllSquares()) {
			if(lineasOcupadas.contains(celda.getY())) {
				celda.setOccupied(true);
			}
		}
		
		return tablero;
	}

}

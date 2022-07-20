package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.SquareNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Board {
	private List<Square> squares;
	private final Integer width = 10;
	private final Integer height = 22;
	
	public Board()  {
		//La cantidad de celdas que tiene el tablero ya están pre-definidas 22 alto * 10 ancho
		this.squares = new ArrayList<Square>();
		for(int posY = 1; posY<=height; posY++) {
			for(int posX = 1; posX<=width; posX++) {
				this.squares.add(new Square(new Position(posX, posY), false));
			}
		}
	}
	public Square getSquare(Integer x, Integer y) throws SquareNotFoundException {
		return squares
			.stream()
			.filter(square -> square.getX() == x && square.getY() == y)
			.findFirst()
			.orElseThrow(() -> new SquareNotFoundException("La celda con posiciones (X: " + x + " Y: "+ y +") no corresponde al tablero de " + width + " de ancho y " + height + "de alto"));
	}

	@Override
	public String toString() {
		String ret = "---Tetris---\n";
		ret = ret + "00123456789X\n";
		for(Square celda : squares) {
			if(celda.getX() == 1) {
				ret = celda.getY() >= 10 ? ret + + celda.getY() : ret +"0" + celda.getY();
			}
			String ocupada = celda.getOccupied() ? "X" : " ";
			ret = ret + ocupada;
			if(celda.getX() == width) {
				ret = ret +"\n";
			}
		}
		return ret;
	}
}

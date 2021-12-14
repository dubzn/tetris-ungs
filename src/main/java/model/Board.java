package model;

import java.util.ArrayList;
import java.util.List;

import exception.SquareNotFoundException;

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
	
	public Integer getHeight() {
		return height;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public List<Square> getAllSquares() {
		return squares;
	}
	
	public void setSquares(List<Square> squares) {
		this.squares = squares;
	}
	
	public Square getSquare(Integer x, Integer y) throws SquareNotFoundException {
		return squares
			.stream()
			.filter(celda -> celda.getX() == x && celda.getY() == y)
			.findFirst()
			.orElseThrow(() -> new SquareNotFoundException("La celda con posiciones (X: " + x + " Y: "+ y +") no corresponde al tablero de " + width + " de ancho y " + height + "de alto"));
	}

	@Override
	public String toString() {
		String ret = "▒▒▒Tetris▒▒▒\n";
		ret = ret + "00123456789X\n";
		for(Square celda : squares) {
			if(celda.getX() == 1) {
				ret = celda.getY() >= 10 ? ret + + celda.getY() : ret +"0" + celda.getY();
			}
			String ocupada = celda.getOccupied() ? "█" : "░";
			ret = ret + ocupada;
			if(celda.getX() == width) {
				ret = ret +"\n";
			}
		}
		
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		result = prime * result + ((squares == null) ? 0 : squares.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		if (squares == null) {
			if (other.squares != null)
				return false;
		} else if (!squares.equals(other.squares))
			return false;
		return true;
	}
	
	
	
}

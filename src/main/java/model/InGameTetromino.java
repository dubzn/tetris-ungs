package model;

import java.util.List;
import java.util.Objects;

public class InGameTetromino extends Tetromino {
	
	private Position position;
	
	public InGameTetromino(String nombre, Position position, List<Square> piezaHorizontal, List<Square> piezaVertical) {
		super(nombre, piezaHorizontal, piezaVertical);
		this.setPosition(position);
	}

	public Integer getX() {
		return position.getX();
	}

	public Integer getY() {
		return position.getY();
	}
	
	public void setX(Integer x) {
		this.position.setX(x);
	}
	
	public void setY(Integer y) {
		this.position.setY(y);
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	
	
	@Override
	public String toString() {
		return "InGameTetromino [position=" + position + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InGameTetromino other = (InGameTetromino) obj;
		return Objects.equals(position, other.position);
	}

	
}

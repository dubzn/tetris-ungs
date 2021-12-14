package model;

import java.util.List;

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

}

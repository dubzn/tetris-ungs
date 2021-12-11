package model;

import java.util.List;

public class PiezaEnJuego extends Pieza {
	
	private Position position;
	
	public PiezaEnJuego(String nombre, Position position, List<Celda> piezaHorizontal, List<Celda> piezaVertical) {
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

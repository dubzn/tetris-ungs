package model;

public enum Movimiento {
	
	IZQUIERDA("izquierda", -1, 0),
	DERECHA("derecha", 1, 0),
	ABAJO("abajo", 0, 1);
	
	private String nombre;
	private Integer movX;
	private Integer movY;
	
	Movimiento(String nombre, Integer x, Integer y) {
		this.nombre = nombre;
		this.movX = x;
		this.movY = y;
	}
	
	public Integer getMovementX() {
		return this.movX;
	}
	
	public Integer getMovementY() {
		return this.movY;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}

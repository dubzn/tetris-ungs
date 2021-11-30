package model;

import java.util.List;

public class Tablero {
	private List<Pieza> piezas;
	private List<Celda> celdas;
	
	public List<Pieza> getPiezasEnTablero() {
		return piezas;
	}
	public void setPiezasEnTablero(List<Pieza> piezasEnTablero) {
		this.piezas = piezasEnTablero;
	}
	public List<Celda> getCeldas() {
		return celdas;
	}
	public void setCeldas(List<Celda> celdas) {
		this.celdas = celdas;
	}
	
}

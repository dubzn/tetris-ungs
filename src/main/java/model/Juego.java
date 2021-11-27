package model;

import java.util.List;

public class Juego {
	private Tablero tablero;
	private List<Pieza> piezas;
	private String modoJuego;
	private Integer puntaje;
	
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	public List<Pieza> getPiezas() {
		return piezas;
	}
	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}
	public String getModoJuego() {
		return modoJuego;
	}
	public void setModoJuego(String modoJuego) {
		this.modoJuego = modoJuego;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
		
}

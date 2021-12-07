package model;

public class Juego {
	private Tablero tablero;
	private ModoJuego modoJuego;
	private Integer puntaje;
	
	
	public Juego(Tablero tablero, ModoJuego modoJuego) {
		this.tablero = tablero;
		this.modoJuego = modoJuego; 
		this.puntaje = 0;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public ModoJuego getModoJuego() {
		return modoJuego;
	}
	
	public Integer getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
		
}

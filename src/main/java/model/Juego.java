package model;

import java.util.List;

import exception.CeldaNotFoundException;

public class Juego {
	
	private Tablero tablero;
	private PiezaEnJuego pieza;
	private ModoJuego modoJuego;
	private Integer puntaje;
	private Integer velocidadGravedad;
	
	public Juego(Tablero tablero, ModoJuego modoJuego) {
		this.tablero = tablero;
		this.modoJuego = modoJuego; 
		this.puntaje = 0;
		this.velocidadGravedad = 1;
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public PiezaEnJuego getPiezaEnJuego() {
		return this.pieza;
	}
	
	public void setPiezaEnJuego(PiezaEnJuego pieza) throws CeldaNotFoundException {
		List<Celda> celdasPieza = pieza
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? pieza.getPiezaHorizontal() : pieza.getPiezaVertical();
				 
		for(Celda celda : celdasPieza) {
			this.tablero.getCelda(celda.getX() + pieza.getX(), celda.getY() + pieza.getY()).setOcupada(true);
		}
		this.pieza = pieza;
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

	public Integer getVelocidadGravedad() {
		return velocidadGravedad;
	}

	public void setVelocidadGravedad(Integer velocidadGravedad) {
		this.velocidadGravedad = velocidadGravedad;
	}

		
}

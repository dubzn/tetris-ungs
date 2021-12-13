package service;

import java.util.List;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Juego;
import model.Movimiento;
import model.Orientacion;
import model.Position;

public class DefaultGravityService implements GravedadService {
	
	private final ColisionService colision;
	
	public DefaultGravityService(ColisionService colision) {
		this.colision = colision;
	}
	
	public Juego run(Juego juego) throws CeldaNotFoundException {
		if(juego.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			appearPiezaEnJuego(juego, false);
			aplicarGravedadAPiezaEnJuego(juego);	
			appearPiezaEnJuego(juego, true);
		}

		return juego;
	}

	private void appearPiezaEnJuego(Juego juego, boolean appear) throws CeldaNotFoundException {	
		List<Celda> celdasPieza = juego.getPiezaEnJuego()
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? juego.getPiezaEnJuego().getPiezaHorizontal() : juego.getPiezaEnJuego().getPiezaVertical();
		
		for(Celda celda : celdasPieza) {
			juego.getTablero().getCelda(celda.getX() + juego.getPiezaEnJuego().getX(), celda.getY() + juego.getPiezaEnJuego().getY()).setOcupada(appear);
		}
	}
	
	private void aplicarGravedadAPiezaEnJuego(Juego juego) throws CeldaNotFoundException {		
		if(juego.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			juego.getPiezaEnJuego().setPosition(new Position(juego.getPiezaEnJuego().getX(), juego.getPiezaEnJuego().getY() + 1));	
		}
		
		if(!colision.canMove(juego, Movimiento.ABAJO)) {
			juego.getPiezaEnJuego().getEstado().setEstaFlotando(false);	
		}
	}
}

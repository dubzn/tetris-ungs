package service;

import java.util.List;
import java.util.Map;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Movimiento;
import model.Orientacion;
import model.Pieza;
import model.Position;
import model.Tablero;

public class DefaultColisionService implements ColisionService {

	@Override
	public boolean canMove(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento) {
		Tablero tableroSinPiezaEnJuego = removePieza(tablero, pieza);
		
		return !colisionaConBorde(tableroSinPiezaEnJuego, pieza, movimiento) && 
			   !colisionaConPieza(tableroSinPiezaEnJuego, pieza, movimiento);		
	}

	private Tablero removePieza(Tablero tablero, Map<Position, Pieza> pieza) {
		Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
		Position position = mapPieza.getKey();
		Pieza piezaEnJuego = mapPieza.getValue();
		
		List<Celda> celdasPieza = piezaEnJuego
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? piezaEnJuego.getPiezaHorizontal() : piezaEnJuego.getPiezaVertical();
		
		try {
			for(Celda celda : celdasPieza) {
				tablero.getCelda(celda.getX() + position.getX(), celda.getY() + position.getY()).setOcupada(false);
			}
		} catch (CeldaNotFoundException e) {
			e.printStackTrace();
		}		
		return tablero;
	}

	private boolean colisionaConPieza(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento) {
		Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
		Position position = mapPieza.getKey();
		Pieza piezaEnJuego = mapPieza.getValue();
		
		List<Celda> celdasPieza = piezaEnJuego
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? piezaEnJuego.getPiezaHorizontal() : piezaEnJuego.getPiezaVertical();
		
		switch(movimiento) {
			case IZQUIERDA:
				return celdasPieza.stream().anyMatch(celda -> canMoveIzquierda(tablero, celda, position));
			case DERECHA:
				return celdasPieza.stream().anyMatch(celda -> canMoveDerecha(tablero, celda, position));
			case ABAJO:			
				return celdasPieza.stream().anyMatch(celda -> canMoveAbajo(tablero, celda, position));
		}
		return false;
	}

	private boolean canMoveIzquierda(Tablero tablero, Celda celdaPieza, Position position) {
		try {
			return tablero.getCelda(celdaPieza.getX() + position.getX() - 1, celdaPieza.getY() + position.getY()).estaOcupada();		
		} catch (CeldaNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean canMoveDerecha(Tablero tablero, Celda celdaPieza, Position position) {
		try {
			return tablero.getCelda(celdaPieza.getX() + position.getX() + 1, celdaPieza.getY() + position.getY()).estaOcupada();		
		} catch (CeldaNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean canMoveAbajo(Tablero tablero, Celda celdaPieza, Position position) {
		try {
			return tablero.getCelda(celdaPieza.getX() + position.getX(), celdaPieza.getY() + position.getY() + 1).estaOcupada();		
		} catch (CeldaNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean colisionaConBorde(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento) {
		Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
		Position position = mapPieza.getKey();
		Pieza piezaEnJuego = mapPieza.getValue();
		
		List<Celda> celdasPieza = piezaEnJuego
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? piezaEnJuego.getPiezaHorizontal() : piezaEnJuego.getPiezaVertical();
		
		switch(movimiento) {
			case IZQUIERDA:
				return celdasPieza.stream().anyMatch(celda -> !(celda.getX() + position.getX() - 1>= 1));
			case DERECHA:
				return celdasPieza.stream().anyMatch(celda -> !(celda.getX() + position.getX() + 1 <= tablero.getAncho()));
			case ABAJO:			
				return celdasPieza.stream().anyMatch(celda -> !(celda.getY() + position.getY() + 1 <= tablero.getAlto()));
		}
		return false;
	}
	
}

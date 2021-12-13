package service;

import java.util.List;
import java.util.Stack;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Juego;
import model.Movimiento;
import model.Orientacion;
import model.PiezaEnJuego;
import model.Position;


public class DefaultMovementService extends MovimientoService {

	private final ColisionService colision;
	
	public DefaultMovementService(ColisionService colision) {
		this.queue = new Stack<>();
		this.colision = colision;	
	}
	
	@Override
	Juego run(Juego juego) throws CeldaNotFoundException {
		if(!this.queue.isEmpty()) {
			Movimiento nextMove = this.queue.pop(); 
			appearPiezaEnJuego(juego, false);
			juego = resolve(juego, nextMove);		
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

	private Juego resolve(Juego juego, Movimiento movimiento) throws CeldaNotFoundException {
		if(movimiento.equals(Movimiento.ROTAR)) {
			Orientacion nextOrientacion = juego.getPiezaEnJuego().getEstado().getOrientacion().equals(Orientacion.HORIZONTAL) ? Orientacion.VERTICAL : Orientacion.HORIZONTAL; 
			juego.getPiezaEnJuego().getEstado().setOrientacion(nextOrientacion);
			return juego;
		}
		
		if(colision.canMove(juego, movimiento)) {
			PiezaEnJuego pieza = juego.getPiezaEnJuego();
			
			List<Celda> celdasPieza = pieza
					 .getEstado()
					 .getOrientacion()
					 .equals(Orientacion.HORIZONTAL) ? juego.getPiezaEnJuego().getPiezaHorizontal() : juego.getPiezaEnJuego().getPiezaVertical();
					 
			for(Celda celda : celdasPieza) {
				juego.getTablero().getCelda(celda.getX() + pieza.getX(), celda.getY() + pieza.getY()).setOcupada(false);
			}	
			
			for(Celda celda : celdasPieza) {
				Integer posicionNuevaX = celda.getX() + pieza.getX() + movimiento.getMovementX();
				Integer posicionNuevaY = celda.getY() + pieza.getY() + movimiento.getMovementY();
				juego.getTablero().getCelda(posicionNuevaX, posicionNuevaY).setOcupada(true);
			}
			System.out.println("SETTING NEW POSITION: x="+(pieza.getX() + movimiento.getMovementX())+" y="+(pieza.getY() + movimiento.getMovementY()));
			pieza.setPosition(new Position(pieza.getX() + movimiento.getMovementX(), pieza.getY() + movimiento.getMovementY()));
		}
		return juego;
	}
}

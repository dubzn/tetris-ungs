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
			juego = resolve(juego, nextMove);		
		}
		
		return juego;
	}

	private Juego resolve(Juego juego, Movimiento movimiento) throws CeldaNotFoundException {
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
				juego.getPiezaEnJuego().setPosition(new Position(posicionNuevaX, posicionNuevaY));
			}
		}
		return juego;
	}
}

package strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Juego;
import model.Movimiento;
import model.Orientacion;
import model.Pieza;
import model.PiezaEnJuego;
import model.Position;
import model.Tablero;
import service.ColisionService;

public class DefaultMovementStrategy implements MovementStrategy {
	
	private final ColisionService colision;
	
	public DefaultMovementStrategy(ColisionService colision) {
		this.colision = colision;
	}

	public Juego execute(Juego juego, Movimiento movimiento) throws CeldaNotFoundException {
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

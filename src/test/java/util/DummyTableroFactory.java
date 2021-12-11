package util;

import java.util.List;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Orientacion;
import model.Pieza;
import model.Position;
import model.Tablero;

public class DummyTableroFactory {
	
	public static Tablero create() {
		return new Tablero();
	}
	
	
	public static Tablero addPieza(Tablero tablero, Position position, Pieza pieza) throws CeldaNotFoundException {
		tablero.getCelda(position.getX(), position.getY());
		
		List<Celda> celdasPieza = pieza.getEstado().getOrientacion().equals(Orientacion.HORIZONTAL) ? pieza.getPiezaHorizontal() : pieza.getPiezaVertical();
		
		for(Celda celda : celdasPieza) {
			tablero.getCelda(position.getX() + celda.getX(), position.getY() + celda.getY()).setOcupada(true);
		}
		
		return tablero;
	}
	
	public static Tablero withPieza(Position position, Pieza pieza) throws CeldaNotFoundException {
		Tablero tablero = new Tablero();
		
		tablero.getCelda(position.getX(), position.getY());
		
		List<Celda> celdasPieza = pieza.getEstado().getOrientacion().equals(Orientacion.HORIZONTAL) ? pieza.getPiezaHorizontal() : pieza.getPiezaVertical();
		
		for(Celda celda : celdasPieza) {
			tablero.getCelda(position.getX() + celda.getX(), position.getY() + celda.getY()).setOcupada(true);
		}
		
		return tablero;
	}
	
	public static Tablero create(List<Integer> lineasOcupadas) {
		Tablero tablero = new Tablero();
		
		for(Celda celda : tablero.getCeldas()) {
			if(lineasOcupadas.contains(celda.getY())) {
				celda.setOcupada(true);
			}
		}
		
		return tablero;
	}

}

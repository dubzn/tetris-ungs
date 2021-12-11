package strategy;

import java.util.List;
import java.util.Map;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Movimiento;
import model.Orientacion;
import model.Pieza;
import model.Position;
import model.Tablero;
import service.ColisionService;

public class DefaultMovementStrategy implements MovementStrategy {
	
	private final ColisionService colision;
	
	public DefaultMovementStrategy(ColisionService colision) {
		this.colision = colision;
	}

	public Tablero execute(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento) throws CeldaNotFoundException {
		try {
			switch (movimiento) {
			case IZQUIERDA:
				return izquierda(tablero, pieza);
			case DERECHA:
				return derecha(tablero, pieza);
			case ABAJO:
				return abajo(tablero, pieza);
			default:
				return tablero;
			}	
		} catch(CeldaNotFoundException e) {
			throw new CeldaNotFoundException(e.getMessage());
		}	
	}

	private Tablero izquierda(Tablero tablero, Map<Position, Pieza> pieza) throws CeldaNotFoundException {
		if(colision.canMove(tablero, pieza, Movimiento.IZQUIERDA)) {
			 Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
			 Celda celda = tablero.getCelda(mapPieza.getKey().getX(), mapPieza.getKey().getY());
			
			 List<Celda> celdasPieza = mapPieza
					 .getValue()
					 .getEstado()
					 .getOrientacion()
					 .equals(Orientacion.HORIZONTAL) ? mapPieza.getValue().getPiezaHorizontal() : mapPieza.getValue().getPiezaVertical();
			 for(Celda celdaPieza : celdasPieza) {
				 tablero.getCelda(celda.getX() + celdaPieza.getX(), celda.getY() + celdaPieza.getY()).setOcupada(false);
			 }
			 
			 for(Celda celdaPieza : celdasPieza) {
				 tablero.getCelda(celda.getX() + celdaPieza.getX() - 1, celda.getY() + celdaPieza.getY()).setOcupada(true);
			 }
		}
		return tablero;
	}
	
	private Tablero derecha(Tablero tablero, Map<Position, Pieza> pieza) throws CeldaNotFoundException {
		if(colision.canMove(tablero, pieza, Movimiento.DERECHA)) {
			Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
			Celda celda = tablero.getCelda(mapPieza.getKey().getX(), mapPieza.getKey().getY());
			 
			List<Celda> celdasPieza = mapPieza
				 .getValue()
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? mapPieza.getValue().getPiezaHorizontal() : mapPieza.getValue().getPiezaVertical();
			for(Celda celdaPieza : celdasPieza) {
				 tablero.getCelda(celda.getX() + celdaPieza.getX(), celda.getY() + celdaPieza.getY()).setOcupada(false);
			 }
			 
			 for(Celda celdaPieza : celdasPieza) {
				 tablero.getCelda(celda.getX() + celdaPieza.getX() + 1, celda.getY() + celdaPieza.getY()).setOcupada(true);
			 } 
		}
		return tablero;
	}
	
	private Tablero abajo(Tablero tablero, Map<Position, Pieza> pieza) throws CeldaNotFoundException {
		if(colision.canMove(tablero, pieza, Movimiento.ABAJO)) {
			Map.Entry<Position,Pieza> mapPieza = pieza.entrySet().iterator().next();
			Celda celda = tablero.getCelda(mapPieza.getKey().getX(), mapPieza.getKey().getY());
			List<Celda> celdasPieza = mapPieza
				 .getValue()
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? mapPieza.getValue().getPiezaHorizontal() : mapPieza.getValue().getPiezaVertical();
			for(Celda celdaPieza : celdasPieza) {
				tablero.getCelda(celda.getX() + celdaPieza.getX(), celda.getY() + celdaPieza.getY()).setOcupada(false);
			}
			 
			for(Celda celdaPieza : celdasPieza) {
				tablero.getCelda(celda.getX() + celdaPieza.getX(), celda.getY() + celdaPieza.getY() + 1 ).setOcupada(true);
			}
			 
		}
		return tablero;
	}

}

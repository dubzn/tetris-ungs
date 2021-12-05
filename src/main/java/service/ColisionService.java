package service;

import java.util.Map;

import model.Movimiento;
import model.Pieza;
import model.Position;
import model.Tablero;

public interface ColisionService {

	/**
	 * 
	 * @param tablero
	 * @param pieza
	 * @param movimiento
	 * @return
	 */
	boolean canMove(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento);
}

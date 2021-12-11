package service;

import exception.CeldaNotFoundException;
import model.Juego;
import model.Movimiento;

public interface ColisionService {

	/**
	 * 
	 * @param tablero
	 * @param pieza
	 * @param movimiento
	 * @return
	 * @throws CeldaNotFoundException 
	 */
	boolean canMove(Juego juego, Movimiento movimiento) throws CeldaNotFoundException;
}

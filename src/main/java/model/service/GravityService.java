package model.service;

import exception.SquareNotFoundException;
import model.Game;

public interface GravityService {

	/**
	 * Debe tomar revisar todas las celdas ocupadas del tablero y en caso de que pueda, dejarlas caer
	 * 
	 * @param tablero - Es el tablero al que se le debe aplicar la gravedad dejando caer las piezas
	 * @throws SquareNotFoundException 
	 */
	Game run(Game juego) throws SquareNotFoundException;
}

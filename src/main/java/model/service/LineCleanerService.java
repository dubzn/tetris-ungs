package model.service;

import model.Game;

public interface LineCleanerService {

	/**
	 * Debe revisar el tablero y si encuentra una l�nea horizontal completa, debe limpiarla
	 * @param tablero
	 * @return
	 */
	Game run(Game juego);	
}

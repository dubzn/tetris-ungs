package service;

import model.Juego;

public interface BorradorLineasService {

	/**
	 * Debe revisar el tablero y si encuentra una l�nea horizontal completa, debe limpiarla
	 * @param tablero
	 * @return
	 */
	Juego run(Juego juego);	
}

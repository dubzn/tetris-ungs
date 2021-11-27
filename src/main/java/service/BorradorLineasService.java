package service;

import model.Tablero;

public interface BorradorLineasService {

	/**
	 * Debe revisar el tablero y si encuentra una l�nea horizontal completa, debe limpiarla
	 * @param tablero
	 * @return
	 */
	Tablero run(Tablero tablero);	
}

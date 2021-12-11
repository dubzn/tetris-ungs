package service;

import exception.CeldaNotFoundException;
import model.Juego;

public interface GravedadService {

	/**
	 * Debe tomar revisar todas las celdas ocupadas del tablero y en caso de que pueda, dejarlas caer
	 * 
	 * @param tablero - Es el tablero al que se le debe aplicar la gravedad dejando caer las piezas
	 * @throws CeldaNotFoundException 
	 */
	Juego run(Juego juego) throws CeldaNotFoundException;
}

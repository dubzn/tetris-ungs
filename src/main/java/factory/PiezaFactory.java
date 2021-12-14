package factory;

import model.Tetromino;

public interface PiezaFactory {

	/**
	 * Generate a random Pieza del pool definido
	 * @return una Pieza aleatoria de la lista pool
	 */
	Tetromino createRandom();

}

package factory;

import model.Tetromino;

public interface TetrominoFactory {

	/**
	 * Generate a random Pieza del pool definido
	 * @return una Pieza aleatoria de la lista pool
	 */
	Tetromino createRandom();

}

package factory;

import model.Pieza;

public interface PiezaFactory {

	/**
	 * Generate a random Pieza del pool definido
	 * @return una Pieza aleatoria de la lista pool
	 */
	Pieza createRandom();

}

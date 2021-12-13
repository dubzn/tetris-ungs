package view;

import model.Juego;

public interface GameViewService {
	
	/**
	 * Debe encargarse de inializar la vista
	 * @param juego 
	 */
	void start();
	
	/**
	 * Tiene la responsabilidad de rendirzar en pantalla tomando los datos del juego
	 * @param juego - datos necesarios para poder renderizar los componentes del Tetris
	 */
	void update(Juego juego);
	
	/**
	 * Debe encargarse de manejar cuando el juego termine o sea necesario cerrarlo
	 * @param juego - datos necesarios para poder finalizar el juego Tetris
	 */
	void finish(Juego juego);
}

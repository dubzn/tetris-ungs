package service;

import model.Juego;

public interface GameService {

	/**
	 * Se encarga de inicializar la pantalla de Tetris 
	 * @param juego - datos necesarios para poder inicializar el juego Tetris
	 */
	void init(String... args);
	
	/**
	 * Se encarga de comenzar el juego
	 * @param juego - datos necesarios para poder inicializar el juego Tetris
	 */
	void start(Juego juego);
	
	
	/**
	 * Debe encargarse de manejar cuando el juego termine o sea necesario cerrarlo
	 * @param juego - datos necesarios para poder finalizar el juego Tetris
	 */
	void finish(Juego juego);
	
	/**
	 * Tiene la responsabilidad de rendirzar en pantalla tomando los datos del juego
	 * @param juego - datos necesarios para poder renderizar los componentes del Tetris
	 */
	void render(Juego juego);
}

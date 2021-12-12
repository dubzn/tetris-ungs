package view;

import model.Juego;
import service.ControlService;

public interface GameViewService {

	/**
	 * Se encarga de inicializar la pantalla de Tetris 
	 * @param juego - datos necesarios para poder inicializar el juego Tetris
	 */
	void init(String... args);
	/**
	
	/**
	 * Debe encargarse de manejar cuando el juego termine o sea necesario cerrarlo
	 * @param juego - datos necesarios para poder finalizar el juego Tetris
	 */
	void finish(Juego juego);
	
	/**
	 * Tiene la responsabilidad de rendirzar en pantalla tomando los datos del juego
	 * @param juego - datos necesarios para poder renderizar los componentes del Tetris
	 */
	void update(Juego juego);
}

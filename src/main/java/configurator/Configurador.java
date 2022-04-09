package configurator;

import model.Game;
import model.Board;

public class Configurador {

	private Board tablero;
	
	public Configurador(Board tablero) {
		this.tablero = tablero;
	}
	
	public Game inicializar() {
		return new Game(tablero);
	}
}

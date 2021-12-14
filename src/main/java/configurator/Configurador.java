package configurator;

import model.Game;
import model.Jugador;
import model.GameMode;
import model.Board;

public class Configurador {

	private Board tablero;
	private GameMode modoJuego;
	
	public Configurador(Board tablero, GameMode modoJuego) {
		this.tablero = tablero;
		this.modoJuego = modoJuego;
	}
	
	public Game inicializar() {
		return new Game(tablero, modoJuego);
	}
}

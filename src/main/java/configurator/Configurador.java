package configurator;

import model.Juego;
import model.Jugador;
import model.ModoJuego;
import model.Tablero;

public class Configurador {

	private Tablero tablero;
	private ModoJuego modoJuego;
	
	public Configurador(Tablero tablero, ModoJuego modoJuego) {
		this.tablero = tablero;
		this.modoJuego = modoJuego;
	}
	
	public Juego inicializar() {
		return new Juego(tablero, modoJuego);
	}
}

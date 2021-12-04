package service;

import factory.GeneradorPieza;
import model.Juego;
import model.Pieza;
import model.Tablero;

public class DefaultOrchestrator implements Orquestador {
	
	private Juego partida;
	private final GravedadService gravedad;
	private final BorradorLineasService borrador;
	private final MovimientoService movimiento;
	private final GameService game;
	private final GeneradorPieza generador;
	
	private Pieza piezaEnJuego;
	private double tiempo;
	
	public DefaultOrchestrator(Juego partida, GravedadService gravedad, BorradorLineasService borrador, MovimientoService movimiento, GameService game, GeneradorPieza generador) {
		this.partida = partida;
		this.gravedad = gravedad;
		this.borrador = borrador;
		this.movimiento = movimiento;
		this.game = game;
		this.generador = generador;

		this.tiempo = 0;	
	}

	public void run() {
		piezaEnJuego = generador.crear();
				
		Tablero tablero = partida.getTablero();
		
		tablero = movimiento.run(tablero, piezaEnJuego);
		
		tablero = borrador.run(tablero);		
		
		tablero = gravedad.run(tablero);
	
		partida.setTablero(tablero);
		
		game.render(partida);
	}

}

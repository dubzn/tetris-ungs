package service;

import model.Juego;
import model.Pieza;

public class DefaultOrchestrator implements Orquestador {
	
	private Juego partida;
	private Pieza piezaEnJuego;
	private Float tiempo;
	private GravedadService gravedad;
	private BorradorLineasService borrador;
	private MovimientoService movimiento;
	private GameService game;
	
	public DefaultOrchestrator(Juego partida, GravedadService gravedad, BorradorLineasService borrador, MovimientoService movimiento, GameService game) {
		this.partida = partida;
		this.gravedad = gravedad;
		this.borrador = borrador;
		this.movimiento = movimiento;
		this.game = game;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}

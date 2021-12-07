package service;

import java.util.HashMap;
import java.util.Map;

import factory.PiezaFactory;
import model.Juego;
import model.Pieza;
import model.Position;
import model.Tablero;
import view.GameService;

public class DefaultOrchestrator implements Orquestador {
	
	private Juego partida;
	private final GravedadService gravedad;
	private final BorradorLineasService borrador;
	private final MovimientoService movimiento;
	private final GameService game;
	private final PiezaFactory factory;
	
	private Map<Position, Pieza> piezaEnJuego;
	private double tiempo;
	
	public DefaultOrchestrator(Juego partida, GravedadService gravedad, BorradorLineasService borrador, MovimientoService movimiento, GameService game, PiezaFactory generador) {
		this.partida = partida;
		this.gravedad = gravedad;
		this.borrador = borrador;
		this.movimiento = movimiento;
		this.game = game;
		this.factory = generador;

		this.tiempo = 0;	
	}

	public void run() {
		for(Position position : piezaEnJuego.keySet()) {
			if(!piezaEnJuego.get(position).getEstado().getEstaFlotando()) { 
				piezaEnJuego = new HashMap<Position, Pieza>();		
				piezaEnJuego.put(new Position(5, 1), factory.createRandom());
			}
		}
		
		partida.setTablero(movimiento.run(partida.getTablero(), piezaEnJuego)); 
		
		partida.setTablero(borrador.run(partida.getTablero()));		
		
		partida.setTablero(gravedad.run(partida.getTablero()));
		
		game.update(partida);
	}

}

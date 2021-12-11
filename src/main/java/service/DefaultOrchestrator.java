package service;

import java.util.HashMap;
import java.util.Map;

import factory.PiezaFactory;
import model.Juego;
import model.Pieza;
import model.Position;
import view.GameViewService;

public class DefaultOrchestrator implements Orquestador {
	
	private Juego partida;
	private final GravedadService gravedad;
	private final BorradorLineasService borrador;
	private final MovimientoService movimiento;
	private final GameViewService game;
	private final PiezaFactory factory;
	
	private Map<Position, Pieza> piezaEnJuego;
	private double tiempo;
	
	public DefaultOrchestrator(Juego partida, GravedadService gravedad, BorradorLineasService borrador, MovimientoService movimiento, GameViewService game, PiezaFactory generador) {
		this.partida = partida;
		this.gravedad = gravedad;
		this.borrador = borrador;
		this.movimiento = movimiento;
		this.game = game;
		this.factory = generador;

		this.tiempo = 0;	
	}

	public void run() {
		if(piezaEnJuego == null) {
			piezaEnJuego = new HashMap<Position, Pieza>();		
			piezaEnJuego.put(new Position(5, 1), factory.createRandom());
			try {
				partida.getTablero().getCelda(5, 1).setOcupada(true);;	
			} catch(Exception e) {
				
			}
		}
		for(Position position : piezaEnJuego.keySet()) {
			if(!piezaEnJuego.get(position).getEstado().getEstaFlotando()) { 
				piezaEnJuego = new HashMap<Position, Pieza>();		
				piezaEnJuego.put(new Position(5, 1), factory.createRandom());
			}
		}
		try {
			System.out.println(partida.getTablero());
			
			partida.setTablero(movimiento.run(partida.getTablero(), piezaEnJuego)); 
			
			partida.setTablero(borrador.run(partida.getTablero()));		
			
			partida.setTablero(gravedad.run(partida.getTablero()));
			
			game.update(partida);
	
		} catch(Exception e) {
			//TODO: do something with exception
		}
	}

}

package service;

import java.util.Objects;

import factory.PiezaFactory;
import model.Juego;
import model.Pieza;
import model.PiezaEnJuego;
import model.Position;
import view.GameViewService;

public class DefaultOrchestrator implements Orquestador {
	
	private Juego partida;
	private final BorradorLineasService borrador;
	private final GameViewService game;
	private final GravedadService gravedad;
	private final MovimientoService movimiento;
	private final PiezaFactory factory;
	
	private double tiempo;
	
	public DefaultOrchestrator(Juego partida, GravedadService gravedad, BorradorLineasService borrador, MovimientoService movimiento, GameViewService game, PiezaFactory generador) {
		this.partida = partida;
		this.borrador = borrador;
		this.game = game;
		this.gravedad = gravedad;
		this.movimiento = movimiento;
		this.factory = generador;

		this.tiempo = 0;	
	}

	public void run() {
		try {
			System.out.println(partida.getTablero());
			partida.setPiezaEnJuego(actualizarPiezaEnJuego());
			
			System.out.println("pieza: "+partida.getPiezaEnJuego().getPiezaHorizontal());
			System.out.println(partida.getPiezaEnJuego().getNombre()+" position: x="+partida.getPiezaEnJuego().getX() + " y="+partida.getPiezaEnJuego().getY()+" alto: "+partida.getPiezaEnJuego().getAlto()+" floating: "+partida.getPiezaEnJuego().getEstado().getEstaFlotando());
			//partida = movimiento.run(partida);
			//partida = borrador.run(partida);
			partida = gravedad.run(partida);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private PiezaEnJuego actualizarPiezaEnJuego() {
		if(Objects.isNull(partida.getPiezaEnJuego())) {
			System.out.println("Pieza en juego es null creando una nueva");
			return crearPiezaEnPosicion(5, 15);
		}
		
		if(!partida.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			System.out.println("La pieza ya no esta flotando creando una nueva");
			return crearPiezaEnPosicion(5, 1);
		}
		
		return partida.getPiezaEnJuego();
	}

	private PiezaEnJuego crearPiezaEnPosicion(Integer x, Integer y) {
		Pieza pieza = factory.createRandom();
		return new PiezaEnJuego(pieza.getNombre(), new Position(x, y), pieza.getPiezaHorizontal(), pieza.getPiezaVertical());
	}

}

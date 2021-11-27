package service;

import java.util.Map;

import model.Celda;
import model.Juego;
import model.Pieza;

public abstract class Orquestador {

	private Juego partida;
	private Map<Pieza, Celda> piezaEnJuego;
	private Float tiempo;
	private GravedadService gravedad;
	private BorradorLineasService borrador;
	private MovimientoService movimiento;
	
	/**
	 * Debe realizar una iteración manejando el orden en el cual se ejecutan los servicios
	 */
	abstract void run();
}

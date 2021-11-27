package service;

import java.util.List;

import model.Movimiento;
import model.Tablero;

public abstract class MovimientoService {
	
	List<Movimiento> queue;
	
	/**
	 * En base a la cola de movimientos, debe retornar el tablero modificado
	 */
	abstract Tablero run(Tablero tablero);
}

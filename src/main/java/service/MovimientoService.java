package service;

import java.util.Stack;

import model.Movimiento;
import model.Pieza;
import model.Tablero;

public abstract class MovimientoService {
	
	Stack<Movimiento> queue;
	
	/**
	 * En base a la cola de movimientos, debe retornar el tablero modificado
	 */
	abstract Tablero run(Tablero tablero, Pieza pieza);
	
	/**
	 * Agregar un movimiento a la cola de movimientos pendientes
	 * @param mov - movimiento realizado por el usuario
	 * @return
	 */
	public Stack<Movimiento> addToQueue(Movimiento mov) {
		if(queue == null) {
			Stack<Movimiento> stack = new Stack<Movimiento>();
			stack.push(mov);
			queue = stack;
		}
		else {
			this.queue.push(mov);		
		}
		
		return this.queue;
	}
	
}

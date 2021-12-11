package service;

import java.util.Stack;

import exception.CeldaNotFoundException;
import model.Juego;
import model.Movimiento;

public abstract class MovimientoService {
	
	Stack<Movimiento> queue;
	
	/**
	 * En base a la cola de movimientos, debe retornar el tablero modificado
	 * @throws CeldaNotFoundException 
	 */
	abstract Juego run(Juego juego) throws CeldaNotFoundException ;
	
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

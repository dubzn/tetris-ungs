package service;

import java.util.Stack;

import exception.SquareNotFoundException;
import model.Game;
import model.Movement;

public abstract class MovementService {
	
	Stack<Movement> queue;
	
	/**
	 * En base a la cola de movimientos, debe retornar el tablero modificado
	 * @throws SquareNotFoundException 
	 */
	abstract Game run(Game juego) throws SquareNotFoundException ;
	
	/**
	 * Agregar un movimiento a la cola de movimientos pendientes
	 * @param mov - movimiento realizado por el usuario
	 * @return
	 */
	public Stack<Movement> addToQueue(Movement mov) {
		if(queue == null) {
			Stack<Movement> stack = new Stack<Movement>();
			stack.push(mov);
			queue = stack;
		}
		else {
			if(this.queue.size() < 2) {
				this.queue.push(mov);					
			}
			if(this.queue.size() == 2) {
				this.queue.clear();
				this.queue.push(mov);
			}
		}
		
		return this.queue;
	}
	
}

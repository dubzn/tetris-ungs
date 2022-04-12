package model.service;

import java.util.*;

import exception.SquareNotFoundException;
import model.Game;
import model.Movement;

public abstract class MovementService {
	
	Queue<Movement> queue;
	
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
	public Queue<Movement> addToQueue(Movement mov) {
		if(queue == null) {
			System.out.println("queue null, creating");
			Queue<Movement> tmp = new LinkedList<>();
			queue = new LinkedList<>();
			queue.add(mov);
		}
		else {
			if(queue.size() < 3) {
				queue.add(mov);
			}
			if(queue.size() == 3) {
				queue.clear();
				this.queue.add(mov);
			}
		}
		return this.queue;
	}
	
}

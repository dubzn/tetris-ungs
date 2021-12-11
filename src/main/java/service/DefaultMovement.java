package service;

import java.util.Stack;

import exception.CeldaNotFoundException;
import model.Juego;
import model.Movimiento;
import strategy.MovementStrategy;


public class DefaultMovement extends MovimientoService {

	private final MovementStrategy strategy;
	
	public DefaultMovement(MovementStrategy strategy) {
		this.queue = new Stack<>();
		this.strategy = strategy;	
	}
	
	@Override
	Juego run(Juego juego) throws CeldaNotFoundException {
		if(!this.queue.isEmpty()) {
			Movimiento nextMove = this.queue.pop(); 
			juego = strategy.execute(juego, nextMove);		
		}
		
		return juego;
	}

}

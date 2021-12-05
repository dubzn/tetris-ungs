package service;

import java.util.Map;

import model.Movimiento;
import model.Pieza;
import model.Position;
import model.Tablero;
import strategy.MovementStrategy;


public class DefaultMovement extends MovimientoService {

	private final MovementStrategy strategy;
	
	public DefaultMovement(MovementStrategy strategy) {
		this.strategy = strategy;	
	}
	
	@Override
	Tablero run(Tablero tablero, Map<Position, Pieza> pieza) {
		Movimiento nextMove = this.queue.pop(); 
		
		tablero = strategy.execute(tablero, pieza, nextMove);
		
		return tablero;
	}

}

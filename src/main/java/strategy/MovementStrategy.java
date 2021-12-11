package strategy;

import exception.CeldaNotFoundException;
import model.Juego;
import model.Movimiento;

public interface MovementStrategy {
	
	Juego execute(Juego juego, Movimiento movimiento) throws CeldaNotFoundException;
}

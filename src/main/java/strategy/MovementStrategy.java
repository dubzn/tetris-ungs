package strategy;

import java.util.Map;

import model.Movimiento;
import model.Pieza;
import model.Position;
import model.Tablero;

public interface MovementStrategy {
	
	Tablero execute(Tablero tablero, Map<Position, Pieza> pieza, Movimiento movimiento);
}

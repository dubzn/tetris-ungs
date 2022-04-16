package model.service;

import model.Movement;
import model.cor.MovementHandler;

public class KeyboardService implements ControlService {

	private final MovementHandler movement;
	
	public KeyboardService(MovementHandler movement) {
		this.movement = movement;
	}

	@Override
	public void addMovement(Movement mov) {
		this.movement.addToQueue(mov);
	}
}

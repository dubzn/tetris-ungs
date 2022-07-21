package service;

import models.Movement;
import core.MovementHandler;

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

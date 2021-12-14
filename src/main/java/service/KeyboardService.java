package service;

import model.Movement;

public class KeyboardService implements ControlService {

	private MovementService movement;
	
	public KeyboardService(MovementService movement) {
		this.movement = movement;
	}

	@Override
	public void addMovement(Movement mov) {
		this.movement.addToQueue(mov);
	}

}

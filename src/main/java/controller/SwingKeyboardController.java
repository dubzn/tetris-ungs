package controller;

import model.Movement;
import service.ControlService;
import service.MovementService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovementService movimiento, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movement mov) { 
		this.control.addMovement(mov);
	}
	
}

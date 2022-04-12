package controller;

import model.Movement;
import model.service.ControlService;
import model.service.MovementService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovementService movimiento, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movement mov) { 
		this.control.addMovement(mov);
	}
	
}

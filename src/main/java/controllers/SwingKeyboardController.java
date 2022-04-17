package controllers;

import models.Movement;
import models.core.MovementHandler;
import models.service.ControlService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovementHandler movement, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movement mov) { 
		this.control.addMovement(mov);
	}
	
}

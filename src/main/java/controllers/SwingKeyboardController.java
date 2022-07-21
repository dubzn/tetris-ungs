package controllers;

import models.Movement;
import core.MovementHandler;
import service.ControlService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovementHandler movement, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movement mov) { 
		this.control.addMovement(mov);
	}
	
}

package controller;

import model.Movement;
import model.cor.MovementHandler;
import model.service.ControlService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovementHandler movement, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movement mov) { 
		this.control.addMovement(mov);
	}
	
}

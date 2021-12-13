package controller;

import model.Movimiento;
import service.ControlService;
import service.MovimientoService;

public class SwingKeyboardController {

	private final ControlService control;
	
	public SwingKeyboardController(MovimientoService movimiento, ControlService control) {
		this.control = control;		
	}
	
	public void addMovement(Movimiento movimiento) { 
		this.control.encolarMovimiento(movimiento);
	}
	
}

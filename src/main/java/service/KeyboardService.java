package service;

import model.Movimiento;

public class KeyboardService implements ControlService {

	private MovimientoService movimiento;
	
	public KeyboardService(MovimientoService movimiento) {
		this.movimiento = movimiento;
	}

	@Override
	public void encolarMovimiento(Movimiento movimiento) {
		this.movimiento.addToQueue(movimiento);
	}

}

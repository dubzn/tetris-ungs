package service;

import model.Movimiento;

public class KeyboardService implements ControlService {

	private MovimientoService movimiento;
	
	public KeyboardService(MovimientoService movimiento) {
		System.out.println("Creando keyboard service "+movimiento);
		this.movimiento = movimiento;
	}

	@Override
	public void encolarMovimiento(Movimiento movimiento) {
		System.out.println("encolando.. "+movimiento.getNombre());
		this.movimiento.addToQueue(movimiento);
	}

}

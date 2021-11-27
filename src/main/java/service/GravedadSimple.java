package service;

import model.Celda;
import model.Tablero;

public class GravedadSimple implements GravedadService {

	public Tablero run(Tablero tablero) {
		for(Celda celda: tablero.getCeldas()) {
		}
		
		return tablero;
	}

}

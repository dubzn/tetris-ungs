package util;

import java.util.ArrayList;
import java.util.List;

import model.Celda;
import model.Pieza;
import model.Tablero;

public class DummyTableroFactory {
	
	public static Tablero create() {
		List<Pieza> piezas = new ArrayList<Pieza>();
		return new Tablero(piezas);
	}
	
	public static Tablero create(List<Integer> lineasOcupadas) {
		List<Pieza> piezas = new ArrayList<Pieza>();
		Tablero tablero = new Tablero(piezas);
		
		for(Celda celda : tablero.getCeldas()) {
			if(lineasOcupadas.contains(celda.getY())) {
				celda.setOcupada(true);
			}
		}
		
		return tablero;
	}

}

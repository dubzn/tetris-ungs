package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Celda;
import model.Tablero;

public class DefaultBorrador implements BorradorLineasService {

	public Tablero run(Tablero tablero) {
		List<Celda> celdas = tablero.getCeldas();
		Map<Integer, Integer> contadorCeldaOcupada = new HashMap<Integer, Integer>();
		
		for (Celda celda : celdas) {
			if(celda.estaOcupada()) {
				if(contadorCeldaOcupada.get(celda.getY()) == null) {
					contadorCeldaOcupada.put(celda.getY(),  1);
					continue;
				}
				contadorCeldaOcupada.put(celda.getY(), contadorCeldaOcupada.get(celda.getY()) + 1);				
			}		
		}

		for(Integer posY : contadorCeldaOcupada.keySet()) {
			if(contadorCeldaOcupada.get(posY) == tablero.getAncho()) {
				tablero = removeLine(tablero, posY);
			}
		}
		
		return tablero;
	}

	private Tablero removeLine(Tablero tablero, Integer lineNumber) {
		List<Celda> celdas =  tablero.getCeldas();
		for (Celda celda : celdas) {
			if (celda.getY() == lineNumber) {
				celda.setOcupada(false);
			}
		}
		tablero.setCeldas(celdas);
		return tablero;
	}

}

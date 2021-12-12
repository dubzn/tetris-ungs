package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Celda;
import model.Juego;
import model.Tablero;

public class DefaultBorradorService implements BorradorLineasService {

	public Juego run(Juego juego) {
		List<Celda> celdas = juego.getTablero().getCeldas();
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
			if(contadorCeldaOcupada.get(posY) == juego.getTablero().getAncho()) {
				juego.setTablero(removeLine(juego.getTablero(), posY));
			}
		}
		
		return juego;
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

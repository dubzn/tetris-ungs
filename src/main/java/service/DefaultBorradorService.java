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
		Map<Integer, Integer> lineasConCeldasOcupadas = countCompletedLines(celdas); ;
		juego = removeCompletedLines(juego, lineasConCeldasOcupadas);
		juego = applyGravity(juego, lineasConCeldasOcupadas);
		
		return juego;
	}

	private Juego applyGravity(Juego juego, Map<Integer, Integer> lineasConCeldasOcupadas) {
		
		return juego;
	}

	private Juego removeCompletedLines(Juego juego, Map<Integer, Integer> lineasConCeldasOcupadas) {
		for(Integer posY : lineasConCeldasOcupadas.keySet()) {
			if(lineasConCeldasOcupadas.get(posY) == juego.getTablero().getAncho()) {
				juego.setTablero(removeLine(juego.getTablero(), posY));
			}
		}
		return juego;
	}

	private Map<Integer, Integer> countCompletedLines(List<Celda> celdas) {
		Map<Integer, Integer> contadorLineasOcupadas = new HashMap<>();
		for (Celda celda : celdas) {
			if(celda.getOcupada()) {
				if(contadorLineasOcupadas.get(celda.getY()) == null) {
					contadorLineasOcupadas.put(celda.getY(),  1);
					continue;
				}
				contadorLineasOcupadas.put(celda.getY(), contadorLineasOcupadas.get(celda.getY()) + 1);				
			}		
		}
		return contadorLineasOcupadas;
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

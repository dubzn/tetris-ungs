package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Square;
import model.Game;
import model.Board;

public class DefaultLineCleanerService implements LineCleanerService {

	public Game run(Game game) {
		List<Square> celdas = game.getBoard().getAllSquares();
		Map<Integer, Integer> lineasConCeldasOcupadas = countCompletedLines(celdas); ;
		game = cleanCompletedLines(game, lineasConCeldasOcupadas);
		game = applyGravity(game, lineasConCeldasOcupadas);
		
		return game;
	}

	private Game applyGravity(Game game, Map<Integer, Integer> lineasConCeldasOcupadas) {
		
		return game;
	}

	private Game cleanCompletedLines(Game game, Map<Integer, Integer> lineasConCeldasOcupadas) {
		for(Integer posY : lineasConCeldasOcupadas.keySet()) {
			if(lineasConCeldasOcupadas.get(posY) == game.getBoard().getWidth()) {
				game.setBoard(cleanLine(game.getBoard(), posY));
			}
		}
		return game;
	}

	private Map<Integer, Integer> countCompletedLines(List<Square> celdas) {
		Map<Integer, Integer> contadorLineasOcupadas = new HashMap<>();
		for (Square celda : celdas) {
			if(celda.getOccupied()) {
				if(contadorLineasOcupadas.get(celda.getY()) == null) {
					contadorLineasOcupadas.put(celda.getY(),  1);
					continue;
				}
				contadorLineasOcupadas.put(celda.getY(), contadorLineasOcupadas.get(celda.getY()) + 1);				
			}		
		}
		return contadorLineasOcupadas;
	}

	private Board cleanLine(Board board, Integer lineNumber) {
		List<Square> celdas =  board.getAllSquares();
		for (Square celda : celdas) {
			if (celda.getY() == lineNumber) {
				celda.setOccupied(false);
			}
		}
		board.setSquares(celdas);
		return board;
	}

}

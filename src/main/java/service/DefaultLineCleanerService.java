package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Board;

public class DefaultLineCleanerService implements LineCleanerService {

	private final ScoreService score;
	
	public DefaultLineCleanerService(ScoreService score) { 
		this.score = score;
	}
	
	public Game run(Game game)  {
		try {
			List<Square> celdas = game.getBoard().getAllSquares();
			Map<Integer, Integer> lineasConCeldasOcupadas = countCompletedLines(celdas); ;
			game = cleanCompletedLines(game, lineasConCeldasOcupadas);
			game = applyGravity(game, lineasConCeldasOcupadas);
		} catch(SquareNotFoundException e) {
			e.printStackTrace();
		}
				
		return game;
	}

	private Game applyGravity(Game game, Map<Integer, Integer> linesWithOccupiedCells) throws SquareNotFoundException {
		for(Integer posY : linesWithOccupiedCells.keySet()) {
			if(linesWithOccupiedCells.get(posY) == game.getBoard().getWidth()) {
				for(int y = posY - 1; y >= 1; y--) {
					for(int x = 1 ; x <= game.getBoard().getWidth() ; x++ ) {
						game.getBoard().getSquare(x, y + 1).setOccupied(game.getBoard().getSquare(x, y).getOccupied());;
					}
				}
			}
		}
		return game;
	}

	private Game cleanCompletedLines(Game game, Map<Integer, Integer> linesWithOccupiedCells) {
		for(Integer posY : linesWithOccupiedCells.keySet()) {
			if(linesWithOccupiedCells.get(posY) == game.getBoard().getWidth()) {
				game.setBoard(cleanLine(game.getBoard(), posY));
				score.add(game, 1);
			}
		}
		return game;
	}

	private Map<Integer, Integer> countCompletedLines(List<Square> squares) {
		Map<Integer, Integer> linesOccupiedCount = new HashMap<>();
		for (Square square : squares) {
			if(square.getOccupied()) {
				if(linesOccupiedCount.get(square.getY()) == null) {
					linesOccupiedCount.put(square.getY(), 1);
					continue;
				}
				linesOccupiedCount.put(square.getY(), linesOccupiedCount.get(square.getY()) + 1);				
			}		
		}
		return linesOccupiedCount;
	}

	private Board cleanLine(Board board, Integer lineNumber) {
		List<Square> squares =  board.getAllSquares();
		for (Square square : squares) {
			if (square.getY() == lineNumber) {
				square.setOccupied(false);
			}
		}
		board.setSquares(squares);
		return board;
	}

}

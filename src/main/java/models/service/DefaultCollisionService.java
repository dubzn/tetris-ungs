package models.service;

import java.util.List;

import exceptions.SquareNotFoundException;
import models.Square;
import models.Game;
import models.Movement;
import utils.Cleaner;

public class DefaultCollisionService implements CollisionService {


	@Override
	public boolean canRotate(Game game) throws SquareNotFoundException {
		List<Square> inGameTetrominoNextRotateForm = game.getInGameTetromino().getNextRotateForm();
		
		Cleaner.appearInGameTetromino(game,false);
		boolean ret = !collideWithBorder(game, inGameTetrominoNextRotateForm, Movement.ROTATE) &&
				!collideWithTetromino(game, inGameTetrominoNextRotateForm, Movement.ROTATE);
		Cleaner.appearInGameTetromino(game, true);

		return ret;
	}
	
	@Override
	public boolean canMove(Game game, Movement movement) throws SquareNotFoundException {
		List<Square> squaresInGameTetromino = game.getInGameTetromino().getSquareListForm();

		Cleaner.appearInGameTetromino(game, false);
		boolean ret = !collideWithBorder(game, squaresInGameTetromino, movement) && !collideWithTetromino(game, squaresInGameTetromino, movement);
		Cleaner.appearInGameTetromino(game, true);

		return ret;
	}


	private boolean collideWithTetromino(Game game, List<Square> squaresInGameTetromino, Movement movement) {
		return squaresInGameTetromino.stream().anyMatch(celda -> resolve(game, celda, movement));
	}

	private boolean resolve(Game game, Square square, Movement movement) {
		try {
			return game.getBoard()
					.getSquare(square.getX() + game.getInGameTetromino().getX() + movement.getMovX(),
							square.getY() + game.getInGameTetromino().getY() + movement.getMovY())
					.getOccupied();
		} catch (SquareNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean collideWithBorder(Game game, List<Square> squaresInGameTetromino, Movement movement) {
		if(movement.equals(Movement.ROTATE)) {
			return !(squaresInGameTetromino.stream().allMatch(square -> 
				game.getInGameTetromino().getX() + square.getX() >= 1 &&
				game.getInGameTetromino().getX() + square.getX() <= game.getBoard().getWidth() &&
				game.getInGameTetromino().getY() + square.getY() <= game.getBoard().getHeight()));
		}
		
		switch (movement) {
		case LEFT:
			return !(game.getInGameTetromino().getX() + movement.getMovX() >= 1);
		case RIGHT:
			return !(game.getInGameTetromino().getX() + game.getInGameTetromino().getWidth() <= game.getBoard().getWidth());
		case DOWN:
			return !(game.getInGameTetromino().getY() + game.getInGameTetromino().getHeight() <= game.getBoard().getHeight());
		default:
			return false;
		}
	}
}

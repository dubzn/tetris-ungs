package model.service;

import java.util.List;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Movement;

public class DefaultCollisionService implements CollisionService {


	@Override
	public boolean canRotate(Game game) throws SquareNotFoundException {
		List<Square> inGameTetrominoNextRotateForm = game.getInGameTetromino().getNextRotateForm();
		
		appearInGameTetromino(game,false);
		boolean ret = !collideWithBorder(game, inGameTetrominoNextRotateForm, Movement.ROTATE);
		appearInGameTetromino(game, true);

		return ret;
	}
	
	@Override
	public boolean canMove(Game game, Movement movimiento) throws SquareNotFoundException {
		List<Square> squaresInGameTetromino = game.getInGameTetromino().getSquareListForm();

		appearInGameTetromino(game, false);
		boolean ret = !collideWithBorder(game, squaresInGameTetromino, movimiento) && !collideWithTetromino(game, squaresInGameTetromino, movimiento);
		appearInGameTetromino(game, true);

		return ret;
	}

	private void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {
		List<Square> squaresInGameTetromino = game.getInGameTetromino().getSquareListForm();
		
		for (Square celda : squaresInGameTetromino) {
			game.getBoard().getSquare(celda.getX() + game.getInGameTetromino().getX(),
					celda.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
		}
	}

	private boolean collideWithTetromino(Game juego, List<Square> squaresInGameTetromino, Movement movimiento) {
		return squaresInGameTetromino.stream().anyMatch(celda -> resolve(juego, celda, movimiento));
	}

	private boolean resolve(Game juego, Square celda, Movement movimiento) {
		try {
			return juego.getBoard()
					.getSquare(celda.getX() + juego.getInGameTetromino().getX() + movimiento.getMovementX(),
							celda.getY() + juego.getInGameTetromino().getY() + movimiento.getMovementY())
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
			return !(game.getInGameTetromino().getX() + movement.getMovementX() >= 1);
		case RIGHT:
			return !(game.getInGameTetromino().getX() + game.getInGameTetromino().getWidth() <= game.getBoard().getWidth());
		case DOWN:
			return !(game.getInGameTetromino().getY() + game.getInGameTetromino().getHeight() <= game.getBoard().getHeight());
		default:
			return false;
		}
	}


}

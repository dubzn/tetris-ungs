package service;

import java.util.List;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Movement;
import model.Orientation;
import model.Position;

public class DefaultGravityService implements GravityService {
	
	private final CollisionService collision;
	
	public DefaultGravityService(CollisionService collision) {
		this.collision = collision;
	}
	
	public Game run(Game game) throws SquareNotFoundException {
		if(game.getInGameTetromino().getState().getIsFloating()) {
			appearInGameTetromino(game, false);
			applyGravityToInGameTetromino(game);	
			appearInGameTetromino(game, true);
		}

		return game;
	}

	private void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {	
		List<Square> celdasPieza = game.getInGameTetromino()
				 .getState()
				 .getOrientation()
				 .equals(Orientation.HORIZONTAL) ? game.getInGameTetromino().getHorizontalForm() : game.getInGameTetromino().getVerticalForm();
		
		for(Square celda : celdasPieza) {
			game.getBoard().getSquare(celda.getX() + game.getInGameTetromino().getX(), celda.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
		}
	}
	
	private void applyGravityToInGameTetromino(Game game) throws SquareNotFoundException {		
		if(game.getInGameTetromino().getState().getIsFloating()) {
			game.getInGameTetromino().setPosition(new Position(game.getInGameTetromino().getX(), game.getInGameTetromino().getY() + 1));	
		}
		
		if(!collision.canMove(game, Movement.DOWN)) {
			game.getInGameTetromino().getState().setIsFloating(false);	
		}
	}
}

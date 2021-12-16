package service;

import java.util.List;
import java.util.Stack;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Movement;
import model.InGameTetromino;
import model.Position;


public class DefaultMovementService extends MovementService {

	private final CollisionService colision;
	
	public DefaultMovementService(CollisionService colision) {
		this.queue = new Stack<>();
		this.colision = colision;	
	}
	
	@Override
	Game run(Game juego) throws SquareNotFoundException {
		if(!this.queue.isEmpty()) {
			Movement nextMove = this.queue.pop(); 
			appearInGameTetromino(juego, false);
			juego = resolve(juego, nextMove);		
			appearInGameTetromino(juego, true);
		}

		return juego;
	}

	private void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {	
		List<Square> celdasPieza = game.getInGameTetromino().getSquareListForm();
		
		for(Square celda : celdasPieza) {
			game.getBoard().getSquare(celda.getX() + game.getInGameTetromino().getX(), celda.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
		}
	}

	private Game resolve(Game game, Movement movimiento) throws SquareNotFoundException {
		if(movimiento.equals(Movement.ROTATE) && colision.canRotate(game)) {
				appearInGameTetromino(game, false);
				game.getInGameTetromino().setNextRotateState();
			return game;
		}
		
		if(!game.getInGameTetromino().getState().getIsFloating()) {
			return game;
		}
		
		if(colision.canMove(game, movimiento)) {
			InGameTetromino pieza = game.getInGameTetromino();
			
			List<Square> celdasPieza = game.getInGameTetromino().getSquareListForm();
								 
			for(Square celda : celdasPieza) {
				game.getBoard().getSquare(celda.getX() + pieza.getX(), celda.getY() + pieza.getY()).setOccupied(false);
			}	
			
			for(Square celda : celdasPieza) {
				Integer posicionNuevaX = celda.getX() + pieza.getX() + movimiento.getMovementX();
				Integer posicionNuevaY = celda.getY() + pieza.getY() + movimiento.getMovementY();
				game.getBoard().getSquare(posicionNuevaX, posicionNuevaY).setOccupied(true);
			}
			pieza.setPosition(new Position(pieza.getX() + movimiento.getMovementX(), pieza.getY() + movimiento.getMovementY()));
		}
		return game;
	}
}

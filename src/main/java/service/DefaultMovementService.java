package service;

import java.util.List;
import java.util.Stack;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Movement;
import model.Orientation;
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
			appearPiezaEnJuego(juego, false);
			juego = resolve(juego, nextMove);		
			appearPiezaEnJuego(juego, true);
		}

		return juego;
	}

	private void appearPiezaEnJuego(Game juego, boolean appear) throws SquareNotFoundException {	
		List<Square> celdasPieza = juego.getInGameTetromino()
				 .getState()
				 .getOrientation()
				 .equals(Orientation.HORIZONTAL) ? juego.getInGameTetromino().getHorizontalForm() : juego.getInGameTetromino().getVerticalForm();
		
		for(Square celda : celdasPieza) {
			juego.getBoard().getSquare(celda.getX() + juego.getInGameTetromino().getX(), celda.getY() + juego.getInGameTetromino().getY()).setOccupied(appear);
		}
	}

	private Game resolve(Game juego, Movement movimiento) throws SquareNotFoundException {
		if(movimiento.equals(Movement.ROTATE)) {
			Orientation nextOrientacion = juego.getInGameTetromino().getState().getOrientation().equals(Orientation.HORIZONTAL) ? Orientation.VERTICAL : Orientation.HORIZONTAL; 
			juego.getInGameTetromino().getState().setOrientation(nextOrientacion);
			return juego;
		}
		
		if(colision.canMove(juego, movimiento)) {
			InGameTetromino pieza = juego.getInGameTetromino();
			
			List<Square> celdasPieza = pieza
					 .getState()
					 .getOrientation()
					 .equals(Orientation.HORIZONTAL) ? juego.getInGameTetromino().getHorizontalForm() : juego.getInGameTetromino().getVerticalForm();
					 
			for(Square celda : celdasPieza) {
				juego.getBoard().getSquare(celda.getX() + pieza.getX(), celda.getY() + pieza.getY()).setOccupied(false);
			}	
			
			for(Square celda : celdasPieza) {
				Integer posicionNuevaX = celda.getX() + pieza.getX() + movimiento.getMovementX();
				Integer posicionNuevaY = celda.getY() + pieza.getY() + movimiento.getMovementY();
				juego.getBoard().getSquare(posicionNuevaX, posicionNuevaY).setOccupied(true);
			}
			System.out.println("SETTING NEW POSITION: x="+(pieza.getX() + movimiento.getMovementX())+" y="+(pieza.getY() + movimiento.getMovementY()));
			pieza.setPosition(new Position(pieza.getX() + movimiento.getMovementX(), pieza.getY() + movimiento.getMovementY()));
		}
		return juego;
	}
}

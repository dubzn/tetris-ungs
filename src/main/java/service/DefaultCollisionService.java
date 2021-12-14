package service;

import java.util.List;

import exception.SquareNotFoundException;
import model.Square;
import model.Game;
import model.Movement;
import model.Orientation;

public class DefaultCollisionService implements CollisionService {


	@Override
	public boolean canRotate(Game juego) throws SquareNotFoundException {
		appearInGameTetromino(juego, false);
		boolean ret = true;
		appearInGameTetromino(juego, true);

		return ret;
	}
	
	@Override
	public boolean canMove(Game juego, Movement movimiento) throws SquareNotFoundException {
		appearInGameTetromino(juego, false);
		boolean ret = !collideWithBorder(juego, movimiento) && !collideWithTetromino(juego, movimiento);
		appearInGameTetromino(juego, true);

		return ret;
	}

	private void appearInGameTetromino(Game juego, boolean appear) throws SquareNotFoundException {
		List<Square> celdasPieza = juego.getInGameTetromino().getState().getOrientation().equals(Orientation.HORIZONTAL)
				? juego.getInGameTetromino().getHorizontalForm()
				: juego.getInGameTetromino().getVerticalForm();

		for (Square celda : celdasPieza) {
			juego.getBoard().getSquare(celda.getX() + juego.getInGameTetromino().getX(),
					celda.getY() + juego.getInGameTetromino().getY()).setOccupied(appear);
		}
	}

	private boolean collideWithTetromino(Game juego, Movement movimiento) {
		List<Square> celdasPieza = juego.getInGameTetromino().getState().getOrientation().equals(Orientation.HORIZONTAL)
				? juego.getInGameTetromino().getHorizontalForm()
				: juego.getInGameTetromino().getVerticalForm();

		return celdasPieza.stream().anyMatch(celda -> resolve(juego, celda, movimiento));
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

	private boolean collideWithBorder(Game juego, Movement movimiento) {
		switch (movimiento) {
		case LEFT:
			return !(juego.getInGameTetromino().getX() + movimiento.getMovementX() >= 1);
		case RIGHT:
			return !(juego.getInGameTetromino().getX() + juego.getInGameTetromino().getWidth() <= juego.getBoard().getWidth());
		case DOWN:
			return !(juego.getInGameTetromino().getY() + juego.getInGameTetromino().getHeight() <= juego.getBoard().getHeight());
		default:
			return false;
		}
	}


}

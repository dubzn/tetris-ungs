package model.service;

import exception.SquareNotFoundException;
import model.Game;
import model.Movement;

public interface CollisionService {

	/**
	 * 
	 * @param tablero
	 * @param pieza
	 * @param movement
	 * @return
	 * @throws SquareNotFoundException 
	 */
	boolean canMove(Game game, Movement movement) throws SquareNotFoundException;
	
	/**
	 * 
	 * @param tablero
	 * @param pieza
	 * @param movement
	 * @return
	 * @throws SquareNotFoundException 
	 */
	boolean canRotate(Game game) throws SquareNotFoundException;
}

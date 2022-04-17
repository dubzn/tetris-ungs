package models.service;

import exceptions.SquareNotFoundException;
import models.Game;
import models.Movement;

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

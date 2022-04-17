package models.service;

import exceptions.SquareNotFoundException;
import models.Game;
import models.Movement;

public interface CollisionService {

	boolean canMove(Game game, Movement movement) throws SquareNotFoundException;
	boolean canRotate(Game game) throws SquareNotFoundException;
}

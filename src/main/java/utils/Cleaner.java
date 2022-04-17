package utils;

import exceptions.SquareNotFoundException;
import models.Game;
import models.Square;

import java.util.List;

public class Cleaner {

  public static void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {
    List<Square> squaresInGameTetromino = game.getInGameTetromino().getSquareListForm();

    for (Square square : squaresInGameTetromino) {
      game.getBoard().getSquare(square.getX() + game.getInGameTetromino().getX(),
              square.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
    }
  }
}

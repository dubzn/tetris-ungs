package models.core;

import exceptions.SquareNotFoundException;
import factory.TetrominoFactory;
import models.Game;
import models.InGameTetromino;
import models.Position;
import models.Tetromino;

import java.util.Objects;

public class TetrominoHandler implements Handler<Game> {

  private final Handler<Game> next;
  private final TetrominoFactory factory;

  public TetrominoHandler(Handler<Game> next, TetrominoFactory factory) {
    this.factory = factory;
    this.next = next;
  }

  @Override
  public void handle(Game request) {
    try {
      request.setInGameTetromino(updateInGameTetromino(request));
      if (!Objects.isNull(next)) {
        next.handle(request);
      }
    } catch (SquareNotFoundException exception) {
      System.out.println("An error occurs in tetromino handler! " + exception.getMessage());
    }
  }

  private InGameTetromino updateInGameTetromino(Game game) throws SquareNotFoundException {
    if (Objects.isNull(game.getInGameTetromino())) {
      game.setNextInGameTetromino(factory.createRandom());
      return createTetrominoInPosition(5, 1);
    }

    if (!game.inGameTetrominoIsFloating()) {
      game.setInGameTetromino(new InGameTetromino(game.getNextInGameTetromino().getName(), new Position(5, 1), game.getNextInGameTetromino()));
      game.setNextInGameTetromino(factory.createRandom());
    }

    return game.getInGameTetromino();
  }

  private InGameTetromino createTetrominoInPosition(Integer x, Integer y) {
    Tetromino tetromino = factory.createRandom();
    return new InGameTetromino(tetromino.getName(), new Position(x, y), tetromino);
  }
}

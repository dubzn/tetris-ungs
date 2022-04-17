package models.core;

import lombok.NoArgsConstructor;
import models.Game;
import models.GameState;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

@NoArgsConstructor
public class GameStateHandler extends Observable implements Handler<Game> {

  private Handler<Game> next;

  public GameStateHandler(Handler<Game> next) {
    this.next = next;
  }

  @Override
  public void handle(Game request) {
    if(!request.inGameTetrominoIsFloating() && request.lastLinesAreOcuppied()) {
      request.setGameState(GameState.FINISH);
    }

    if (!Objects.isNull(next)) {
      next.handle(request);
    }

    this.setChanged();
    this.notifyObservers(request);
  }
}

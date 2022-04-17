package models.core;

import lombok.NoArgsConstructor;
import models.Game;
import models.GameState;

import java.util.Objects;

@NoArgsConstructor
public class GameStateHandler implements Handler<Game> {

  private Handler<Game> next;

  public GameStateHandler(Handler<Game> next) {
    this.next = next;
  }

  @Override
  public void handle(Game request) {
    if(!request.getInGameTetromino().getState().getIsFloating() && request.lastLinesAreOcuppied()) {
      request.setGameState(GameState.FINISH);
    }

    if (!Objects.isNull(next)) {
      next.handle(request);
    }
  }
}

package model.cor;

import model.Game;
import model.GameState;

import java.util.Objects;

public class GameHandler implements Handler<Game> {

    private final Handler<Game> next;

    public GameHandler(Handler<Game> next) {
        this.next = next;
    }

    @Override
    public void handle(Game request) {
        if (Objects.isNull(next)) return;

        if(request.lastLinesAreOcuppied()) {
            request.setGameState(GameState.FINISH);
        }
    }
}

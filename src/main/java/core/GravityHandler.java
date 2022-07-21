package core;

import exceptions.SquareNotFoundException;
import models.Game;
import models.Movement;
import models.Position;
import service.CollisionService;
import service.TimeService;
import utils.Cleaner;

import java.util.Objects;

public class GravityHandler implements Handler<Game> {

    private Handler<Game> next;
    private final CollisionService collision;
    private final TimeService time;

    public GravityHandler(CollisionService collision, TimeService time) {
        this.collision = collision;
        this.time = time;
    }

    public GravityHandler(Handler<Game> next, CollisionService collision, TimeService time) {
        this.collision = collision;
        this.time = time;
        this.next = next;
    }

    @Override
    public void handle(Game request) {
        try {
            if(time.shouldUpdateGravity(request.getGravityVelocity())) {
                applyGravity(request);
                time.setLastTimeUpdated(time.getTimeInSeconds());
            }
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in gravity handler! " + exception.getMessage());
        }

        if (!Objects.isNull(next)) {
            next.handle(request);
        }
    }

    private Game applyGravity(Game game) throws SquareNotFoundException {
        if(game.inGameTetrominoIsFloating()) {
            Cleaner.appearInGameTetromino(game, false);
            applyGravityToInGameTetromino(game);
            Cleaner.appearInGameTetromino(game, true);
        }

        return game;
    }

    private void applyGravityToInGameTetromino(Game game) throws SquareNotFoundException {
        if(collision.canMove(game, Movement.DOWN)) {
            Cleaner.appearInGameTetromino(game, false);
            game.getInGameTetromino().setPosition(new Position(game.getInGameTetromino().getX(), game.getInGameTetromino().getY() + 1));
        } else {
            game.getInGameTetromino().getState().setIsFloating(false);
        }
    }
}

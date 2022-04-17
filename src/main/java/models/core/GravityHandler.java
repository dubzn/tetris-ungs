package models.core;

import exceptions.SquareNotFoundException;
import models.Game;
import models.Movement;
import models.Position;
import models.service.CollisionService;
import models.service.TimeService;
import utils.Cleaner;

import java.util.Objects;
import java.util.Observable;

public class GravityHandler extends Observable implements Handler<Game> {

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

            if (!Objects.isNull(next)) {
                next.handle(request);
            }
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in gravity handler! " + exception.getMessage());
        }
    }

    private Game applyGravity(Game game) throws SquareNotFoundException {
        if(game.getInGameTetromino().getState().getIsFloating()) {
            Cleaner.appearInGameTetromino(game, false);
            applyGravityToInGameTetromino(game);
            Cleaner.appearInGameTetromino(game, true);

            setChanged();
            notifyObservers(game);
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

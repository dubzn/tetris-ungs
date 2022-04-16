package model.cor;

import exception.SquareNotFoundException;
import model.Game;
import model.Movement;
import model.Position;
import model.Square;
import model.service.CollisionService;
import model.service.TimeService;

import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class GravityHandler extends Observable implements Handler<Game> {

    private final Handler<Game> next;
    private final CollisionService collision;
    private final TimeService time;

    public GravityHandler(Handler<Game> next, CollisionService collision, TimeService time) {
        this.collision = collision;
        this.time = time;
        this.next = next;
    }

    @Override
    public void handle(Game request) {
        if (Objects.isNull(next)) return;

        try {
            if(time.shouldUpdateGravity(request.getGravityVelocity())) {
                request = run(request);
                time.setLastTimeUpdated(time.getTimeInSeconds());
            }
            next.handle(request);
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in gravity handler! " + exception.getMessage());
        }
    }

    public Game run(Game game) throws SquareNotFoundException {
        if(game.getInGameTetromino().getState().getIsFloating()) {
            appearInGameTetromino(game, false);
            applyGravityToInGameTetromino(game);
            appearInGameTetromino(game, true);

            setChanged();
            notifyObservers(game);
        }

        return game;
    }

    private void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {
        List<Square> celdasPieza = game.getInGameTetromino().getSquareListForm();

        for(Square celda : celdasPieza) {
            game.getBoard().getSquare(celda.getX() + game.getInGameTetromino().getX(), celda.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
        }
    }

    private void applyGravityToInGameTetromino(Game game) throws SquareNotFoundException {
        if(collision.canMove(game, Movement.DOWN)) {
            appearInGameTetromino(game, false);
            game.getInGameTetromino().setPosition(new Position(game.getInGameTetromino().getX(), game.getInGameTetromino().getY() + 1));
        } else {
            game.getInGameTetromino().getState().setIsFloating(false);
        }
    }
}

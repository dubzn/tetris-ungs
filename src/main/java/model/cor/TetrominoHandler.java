package model.cor;

import exception.SquareNotFoundException;
import factory.TetrominoFactory;
import model.Game;
import model.InGameTetromino;
import model.Position;
import model.Tetromino;

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
        if (Objects.isNull(next)) return;

        try {
        request.setInGameTetromino(updateInGameTetromino(request));
        next.handle(request);
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in tetromino handler! " + exception.getMessage());
        }
    }

    private InGameTetromino updateInGameTetromino(Game game) throws SquareNotFoundException {
        if (Objects.isNull(game.getInGameTetromino())) {
            game.setNextInGameTetromino(factory.createRandom());
            return createTetrominoInPosition(5, 1);
        }

        if (!game.getInGameTetromino().getState().getIsFloating()) {
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

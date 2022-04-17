package models.core;

import exceptions.SquareNotFoundException;
import models.Board;
import models.Game;
import models.Square;
import models.service.ScoreService;

import java.util.*;

public class CleanerHandler extends Observable implements Handler<Game>  {

    private Handler<Game> next;
    private final ScoreService score;

    public CleanerHandler(ScoreService score) {
        this.score = score;
    }

    public CleanerHandler(Handler<Game> next, ScoreService score) {
        this.next = next;
        this.score = score;
    }

    @Override
    public void handle(Game request) {
        try {
            if(!request.getInGameTetromino().getState().getIsFloating()) {
                List<Square> squares = request.getBoard().getSquares();
                Map<Integer, Integer> linesWithCompletedSquares = countCompletedLines(squares); ;
                cleanCompletedLines(request, linesWithCompletedSquares);
                applyGravity(request, linesWithCompletedSquares);
            }
            if (!Objects.isNull(next)) {
                next.handle(request);
            }
        } catch(SquareNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Game applyGravity(Game game, Map<Integer, Integer> linesWithOccupiedCells) throws SquareNotFoundException {
        for(Integer posY : linesWithOccupiedCells.keySet()) {
            if(linesWithOccupiedCells.get(posY) == game.getBoard().getWidth()) {
                for(int y = posY - 1; y >= 1; y--) {
                    for(int x = 1 ; x <= game.getBoard().getWidth() ; x++ ) {
                        game.getBoard().getSquare(x, y + 1).setOccupied(game.getBoard().getSquare(x, y).getOccupied());;
                    }
                }
            }
        }
        return game;
    }

    private Game cleanCompletedLines(Game game, Map<Integer, Integer> linesWithOccupiedCells) {
        for(Integer posY : linesWithOccupiedCells.keySet()) {
            if(linesWithOccupiedCells.get(posY) == game.getBoard().getWidth()) {
                game.setBoard(cleanLine(game.getBoard(), posY));
                score.add(game, 1);
            }
        }
        return game;
    }

    private Map<Integer, Integer> countCompletedLines(List<Square> squares) {
        Map<Integer, Integer> linesOccupiedCount = new HashMap<>();
        for (Square square : squares) {
            if(square.getOccupied()) {
                if(linesOccupiedCount.get(square.getY()) == null) {
                    linesOccupiedCount.put(square.getY(), 1);
                    continue;
                }
                linesOccupiedCount.put(square.getY(), linesOccupiedCount.get(square.getY()) + 1);
            }
        }
        return linesOccupiedCount;
    }

    private Board cleanLine(Board board, Integer lineNumber) {
        List<Square> squares =  board.getSquares();
        for (Square square : squares) {
            if (square.getY() == lineNumber) {
                square.setOccupied(false);
            }
        }
        board.setSquares(squares);
        return board;
    }
}

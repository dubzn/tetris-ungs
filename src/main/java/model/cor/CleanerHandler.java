package model.cor;

import exception.SquareNotFoundException;
import model.Board;
import model.Game;
import model.Square;
import model.service.ScoreService;

import java.util.*;

public class CleanerHandler extends Observable implements Handler<Game>  {

    private final Handler<Game> next;
    private final ScoreService score;

    public CleanerHandler(Handler<Game> next, ScoreService score) {
        this.next = next;
        this.score = score;
    }

    @Override
    public void handle(Game request) {
        if (Objects.isNull(next)) return;

        try {
            List<Square> celdas = request.getBoard().getAllSquares();
            Map<Integer, Integer> lineasConCeldasOcupadas = countCompletedLines(celdas); ;
            request = cleanCompletedLines(request, lineasConCeldasOcupadas);
            request = applyGravity(request, lineasConCeldasOcupadas);

            next.handle(request);
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
        List<Square> squares =  board.getAllSquares();
        for (Square square : squares) {
            if (square.getY() == lineNumber) {
                square.setOccupied(false);
            }
        }
        board.setSquares(squares);
        return board;
    }
}

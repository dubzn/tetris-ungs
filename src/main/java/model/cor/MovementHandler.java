package model.cor;

import exception.SquareNotFoundException;
import model.*;
import model.service.CollisionService;

import java.util.*;

public class MovementHandler extends Observable implements Handler<Game> {

    private final Handler<Game> next;
    private Queue<Movement> queue;
    private final CollisionService colision;

    public MovementHandler(Handler<Game> next, CollisionService colision) {
        this.next = next;
        this.colision = colision;
        this.queue = new LinkedList<>();
    }

    @Override
    public void handle(Game request) {
        if (Objects.isNull(next)) return;

        try {
            if(!this.queue.isEmpty()) {
                Movement nextMove = this.queue.poll();
                appearInGameTetromino(request, false);
                request = resolve(request, nextMove);
                appearInGameTetromino(request, true);

                setChanged();
                notifyObservers(request);
            }
            next.handle(request);
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in movement handler! " + exception.getMessage());
        }
    }

    private void appearInGameTetromino(Game game, boolean appear) throws SquareNotFoundException {
        List<Square> celdasPieza = game.getInGameTetromino().getSquareListForm();

        for(Square celda : celdasPieza) {
            game.getBoard().getSquare(celda.getX() + game.getInGameTetromino().getX(), celda.getY() + game.getInGameTetromino().getY()).setOccupied(appear);
        }
    }

    private Game resolve(Game game, Movement movimiento) throws SquareNotFoundException {
        if(movimiento.equals(Movement.ROTATE) && colision.canRotate(game)) {
            appearInGameTetromino(game, false);
            game.getInGameTetromino().setNextRotateState();
            return game;
        }

        if(!game.getInGameTetromino().getState().getIsFloating()) {
            return game;
        }

        if(colision.canMove(game, movimiento)) {
            InGameTetromino pieza = game.getInGameTetromino();

            List<Square> celdasPieza = game.getInGameTetromino().getSquareListForm();

            for(Square celda : celdasPieza) {
                game.getBoard().getSquare(celda.getX() + pieza.getX(), celda.getY() + pieza.getY()).setOccupied(false);
            }

            for(Square celda : celdasPieza) {
                Integer posicionNuevaX = celda.getX() + pieza.getX() + movimiento.getMovementX();
                Integer posicionNuevaY = celda.getY() + pieza.getY() + movimiento.getMovementY();
                game.getBoard().getSquare(posicionNuevaX, posicionNuevaY).setOccupied(true);
            }
            pieza.setPosition(new Position(pieza.getX() + movimiento.getMovementX(), pieza.getY() + movimiento.getMovementY()));
        }
        return game;
    }

    /**
     * Agregar un movimiento a la cola de movimientos pendientes
     * @param mov - movimiento realizado por el usuario
     * @return
     */
    public Queue<Movement> addToQueue(Movement mov) {
        if(queue == null) {
            System.out.println("queue null, creating");
            Queue<Movement> tmp = new LinkedList<>();
            queue = new LinkedList<>();
            queue.add(mov);
        }
        else {
            if(queue.size() < 2) {
                queue.add(mov);
            }
            if(queue.size() == 2) {
                queue.clear();
                this.queue.add(mov);
            }
        }
        return this.queue;
    }
}

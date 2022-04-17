package models.core;

import exceptions.SquareNotFoundException;
import models.*;
import models.service.CollisionService;
import utils.Cleaner;

import java.util.*;

public class MovementHandler implements Handler<Game> {

    private Handler<Game> next;
    private Queue<Movement> queue;
    private final CollisionService colision;

    public MovementHandler(CollisionService colision) {
        this.colision = colision;
        this.queue = new LinkedList<>();
    }

    public MovementHandler(Handler<Game> next, CollisionService colision) {
        this.next = next;
        this.colision = colision;
        this.queue = new LinkedList<>();
    }

    @Override
    public void handle(Game request) {
        try {
            if(!this.queue.isEmpty()) {
                Movement nextMove = this.queue.poll();
                Cleaner.appearInGameTetromino(request, false);
                request = resolve(request, nextMove);
                Cleaner.appearInGameTetromino(request, true);
            }

            if (!Objects.isNull(next)) {
                next.handle(request);
            }
        } catch (SquareNotFoundException exception) {
            System.out.println("An error occurs in movement handler! " + exception.getMessage());
        }
    }

    private Game resolve(Game game, Movement movimiento) throws SquareNotFoundException {
        if(movimiento.equals(Movement.ROTATE) && colision.canRotate(game)) {
            Cleaner.appearInGameTetromino(game, false);
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
                Integer posicionNuevaX = celda.getX() + pieza.getX() + movimiento.getMovX();
                Integer posicionNuevaY = celda.getY() + pieza.getY() + movimiento.getMovY();
                game.getBoard().getSquare(posicionNuevaX, posicionNuevaY).setOccupied(true);
            }
            pieza.setPosition(new Position(pieza.getX() + movimiento.getMovX(), pieza.getY() + movimiento.getMovY()));
        }
        return game;
    }

    /**
     * Agregar un movimiento a la cola de movimientos pendientes
     * @param mov - movimiento realizado por el usuario
     */
    public void addToQueue(Movement mov) {
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
    }
}

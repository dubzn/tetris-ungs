package service;

import java.util.Objects;

import exception.SquareNotFoundException;
import factory.TetrominoFactory;
import model.Game;
import model.Tetromino;
import model.InGameTetromino;
import model.Position;
import view.GameViewService;

public class DefaultOrchestrator implements Orquestador {

	private Game game;
	private final LineCleanerService lineCleaner;
	private final GameViewService view;
	private final GravityService gravity;
	private final MovementService movement;
	private final TetrominoFactory factory;
	private TimeService time;
	
	public DefaultOrchestrator(Game game, LineCleanerService lineCleaner, GravityService gravity,
			GameViewService view, MovementService movement, TetrominoFactory tetrominoFactory) {

		this.game = game;
		this.lineCleaner = lineCleaner;
		this.gravity = gravity;
		this.view = view;
		this.movement = movement;
		this.factory = tetrominoFactory;

		this.time = new TimeService();
	}

	public void run() {
		try {
			game.setInGameTetromino(updateInGameTetromino());

			// check if player do a movement
			game = movement.run(game);

			if(time.shouldUpdateGravity(game.getGravityVelocity())) {
				game = gravity.run(game);	
				time.setLastTimeUpdated(time.getTimeInSeconds());
			}
			
			if(!game.getInGameTetromino().getState().getIsFloating()) {
				game = lineCleaner.run(game);
				game.checkIfPlayerLose();
			}

			view.update(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private InGameTetromino updateInGameTetromino() throws SquareNotFoundException {
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

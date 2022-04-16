package model.service;

import java.util.Objects;
import java.util.Observable;

import exception.SquareNotFoundException;
import factory.TetrominoFactory;
import model.Game;
import model.Tetromino;
import model.InGameTetromino;
import model.Position;
import view.GameViewService;

public class Orchestrator {

	private Game game;
	private final LineCleanerService lineCleaner;
	private final GravityService gravity;
	private final MovementService movement;
	private final TetrominoFactory factory;
	private TimeService time;
	
	public Orchestrator(Game game, LineCleanerService lineCleaner, GravityService gravity,
						MovementService movement, TetrominoFactory tetrominoFactory) {

		this.game = game;
		this.lineCleaner = lineCleaner;
		this.gravity = gravity;
		this.movement = movement;
		this.factory = tetrominoFactory;
		this.time = new TimeService();
	}

	public Orchestrator(Builder builder) {
		this.game = builder.game;
		this.lineCleaner = builder.lineCleaner;
		this.gravity = builder.gravity;
		this.movement = builder.movement;
		this.factory = builder.factory;
		this.time = new TimeService();
	}

	public static class Builder {
		private Game game;
		private LineCleanerService lineCleaner;
		private GravityService gravity;
		private MovementService movement;
		private TetrominoFactory factory;

		public Builder withGame(Game game) {
			this.game = game;
			return this;
		}

		public Builder withLineCleaner(LineCleanerService lineCleaner) {
			this.lineCleaner = lineCleaner;
			return this;
		}

		public Builder withGravityService(GravityService gravity) {
			this.gravity = gravity;
			return this;
		}

		public Builder withMovementService(MovementService movement) {
			this.movement = movement;
			return this;
		}

		public Builder withTetrominoFactory(TetrominoFactory factory) {
			this.factory = factory;
			return this;
		}

		public Orchestrator build() {
			return new Orchestrator(this);
		}
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
			}
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

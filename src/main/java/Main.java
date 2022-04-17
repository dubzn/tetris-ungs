import controllers.SwingKeyboardController;
import controllers.SwingMainController;
import factory.ClassicTetrisPiezaFactory;
import models.Board;
import models.Game;
import models.core.*;
import models.service.*;

public class Main {
	public static void main(String[] args) {
		GameStateHandler gameHandler = new GameStateHandler();
		CleanerHandler cleanerHandler = new CleanerHandler(gameHandler, new DefaultScoreService());
		GravityHandler gravityHandler = new GravityHandler(cleanerHandler, new DefaultCollisionService(), new TimeService());
		MovementHandler movementHandler = new MovementHandler(gravityHandler, new DefaultCollisionService());
		TetrominoHandler tetrominoHandler = new TetrominoHandler(movementHandler, new ClassicTetrisPiezaFactory());

		KeyboardService keyboard = new KeyboardService(movementHandler);
		SwingKeyboardController keyboardController = new SwingKeyboardController(movementHandler, keyboard);
		SwingMainController viewController = new SwingMainController(keyboardController);

		gravityHandler.addObserver(viewController);
		movementHandler.addObserver(viewController);
		viewController.start();

		Game game = new Game(new Board());
		while (true) {
			tetrominoHandler.handle(game);
		}
	}
}

import controller.SwingKeyboardController;
import controller.SwingMainController;
import factory.ClassicTetrisPiezaFactory;
import model.Board;
import model.Game;
import model.cor.*;
import model.service.*;

public class Main {
	public static void main(String[] args) {
		GameHandler gameHandler = new GameHandler(null);
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

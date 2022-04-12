import controller.SwingKeyboardController;
import controller.SwingMainController;
import exception.SquareNotFoundException;
import factory.ClassicTetrisPiezaFactory;
import model.Board;
import model.Game;
import model.service.DefaultLineCleanerService;
import model.service.DefaultCollisionService;
import model.service.DefaultGravityService;
import model.service.DefaultMovementService;
import model.service.Orchestrator;
import model.service.DefaultScoreService;
import model.service.KeyboardService;

public class Main {	
	public static void main(String[] args) {
		DefaultMovementService movimientoService = new DefaultMovementService(new DefaultCollisionService());
		KeyboardService keyboard = new KeyboardService(movimientoService);
		SwingKeyboardController keyboardController = new SwingKeyboardController(movimientoService, keyboard);
		SwingMainController viewController = new SwingMainController(keyboardController);

		Orchestrator orchestrator = new Orchestrator.Builder()
			.withGame(new Game(new Board()))
			.withLineCleaner(new DefaultLineCleanerService(new DefaultScoreService()))
			.withGravityService(new DefaultGravityService(new DefaultCollisionService()))
			.withMovementService(movimientoService)
			.withTetrominoFactory(new ClassicTetrisPiezaFactory())
			.build();

		orchestrator.addObserver(viewController);
		viewController.start();
		try {
			while(true) {
				orchestrator.run();
				Thread.sleep(33);			
			}
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}

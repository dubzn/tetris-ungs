import configurator.Configurador;
import controller.SwingKeyboardController;
import controller.SwingMainController;
import exception.SquareNotFoundException;
import factory.ClassicTetrisPiezaFactory;
import model.Board;
import service.DefaultLineCleanerService;
import service.DefaultCollisionService;
import service.DefaultGravityService;
import service.DefaultMovementService;
import service.DefaultOrchestrator;
import service.DefaultScoreService;
import service.KeyboardService;
import service.Orquestador;

public class Main {	
	public static void main(String[] args) throws SquareNotFoundException {
		
				
		
		Configurador config = new Configurador(new Board());
		
		DefaultMovementService movimientoService = new DefaultMovementService(new DefaultCollisionService());
		KeyboardService keyboard = new KeyboardService(movimientoService);
		SwingKeyboardController keyboardController = new SwingKeyboardController(movimientoService, keyboard);
		
		SwingMainController viewController = new SwingMainController(keyboardController);
		
		Orquestador orquestrador = new DefaultOrchestrator(
					config.inicializar(), 
					new DefaultLineCleanerService(new DefaultScoreService()), 
					new DefaultGravityService(new DefaultCollisionService()),
					viewController,
					movimientoService, 
					new ClassicTetrisPiezaFactory());	
		try
		{
			viewController.start();
			while(true) {
				orquestrador.run();
				Thread.sleep(33);			
			}
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}

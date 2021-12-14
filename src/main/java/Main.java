import configurator.Configurador;
import controller.SwingKeyboardController;
import controller.SwingMainController;
import factory.ClassicTetrisPiezaFactory;
import model.GameMode;
import model.Board;
import service.DefaultLineCleanerService;
import service.DefaultCollisionService;
import service.DefaultGravityService;
import service.DefaultMovementService;
import service.DefaultOrchestrator;
import service.KeyboardService;
import service.Orquestador;

public class Main {	
	public static void main(String[] args) {
		Configurador config = new Configurador(new Board(), GameMode.SUPERVIVENCIA);
		
		DefaultMovementService movimientoService = new DefaultMovementService(new DefaultCollisionService());
		KeyboardService keyboard = new KeyboardService(movimientoService);
		SwingKeyboardController keyboardController = new SwingKeyboardController(movimientoService, keyboard);
		
		SwingMainController viewController = new SwingMainController(keyboardController);
		
		Orquestador orquestrador = new DefaultOrchestrator(
					config.inicializar(), 
					new DefaultLineCleanerService(), 
					new DefaultGravityService(new DefaultCollisionService()),
					viewController,
					movimientoService, 
					new ClassicTetrisPiezaFactory());	
		try
		{
			viewController.start();
			int iteraciones = 0;
			while(true) {
				System.out.println(iteraciones);
				orquestrador.run();
				Thread.sleep(250);
				iteraciones++;
			
			}
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}

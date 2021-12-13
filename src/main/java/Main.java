import configurator.Configurador;
import controller.SwingKeyboardController;
import controller.SwingMainController;
import factory.ClassicTetrisPiezaFactory;
import model.ModoJuego;
import model.Tablero;
import service.DefaultBorradorService;
import service.DefaultColisionService;
import service.DefaultGravityService;
import service.DefaultMovementService;
import service.DefaultOrchestrator;
import service.KeyboardService;
import service.Orquestador;

public class Main {	
	public static void main(String[] args) {
		Configurador config = new Configurador(new Tablero(), ModoJuego.SUPERVIVENCIA);
		
		DefaultMovementService movimientoService = new DefaultMovementService(new DefaultColisionService());
		KeyboardService keyboard = new KeyboardService(movimientoService);
		SwingKeyboardController keyboardController = new SwingKeyboardController(movimientoService, keyboard);
		
		SwingMainController viewController = new SwingMainController(keyboardController);
		
		Orquestador orquestrador = new DefaultOrchestrator(
					config.inicializar(), 
					new DefaultBorradorService(), 
					new DefaultGravityService(new DefaultColisionService()),
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
				Thread.sleep(1000);
				iteraciones++;
			
			}
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}

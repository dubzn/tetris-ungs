import configurator.Configurador;
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
import view.SwingGameView;

public class Main {	
	public static void main(String[] args) {
		Configurador config = new Configurador(new Tablero(), ModoJuego.SUPERVIVENCIA);
		
		DefaultMovementService movimientoService = new DefaultMovementService(new DefaultColisionService());
		
		SwingGameView view = new SwingGameView();
		KeyboardService keyboard = new KeyboardService(movimientoService);
		
		Orquestador orquestrador = 
				new DefaultOrchestrator(
					config.inicializar(), 
					new DefaultBorradorService(), 
					new DefaultGravityService(new DefaultColisionService()),
					view,
					keyboard,
					movimientoService, 
					new ClassicTetrisPiezaFactory());	
		
		try
		{
			int iteraciones = 0;
			while(true) {
				System.out.println(iteraciones);
				orquestrador.run();
				Thread.sleep(500);
				iteraciones++;
			
			}
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}

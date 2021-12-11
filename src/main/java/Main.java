import configurator.Configurador;
import factory.ClassicTetrisPiezaFactory;
import model.ModoJuego;
import model.Tablero;
import service.DefaultBorrador;
import service.DefaultColisionService;
import service.DefaultGravity;
import service.DefaultMovement;
import service.DefaultOrchestrator;
import service.Orquestador;
import strategy.DefaultMovementStrategy;
import view.JavaFXService;

public class Main {	
	public static void main(String[] args) {
		Configurador config = new Configurador(new Tablero(), ModoJuego.SUPERVIVENCIA);
		
		Orquestador orquestrador = 
				new DefaultOrchestrator(config.inicializar(), 
				new DefaultGravity(new DefaultColisionService()), 
				new DefaultBorrador(), 
				new DefaultMovement(new DefaultMovementStrategy(new DefaultColisionService())), 
				new JavaFXService(),
				new ClassicTetrisPiezaFactory());
		
		while(true) { 
			try
			{
				orquestrador.run();
				Thread.sleep(500);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		
		
	}
}

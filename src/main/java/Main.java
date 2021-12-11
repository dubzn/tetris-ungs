import configurator.Configurador;
import model.Juego;
import model.ModoJuego;
import model.Tablero;
import view.GameViewService;
import view.JavaFXService;

public class Main {	
	public static void main(String[] args) {
		Tablero defaultTablero = new Tablero();
		Configurador config = new Configurador(defaultTablero, ModoJuego.SUPERVIVENCIA);
		Juego juego = config.inicializar();
		
		GameViewService game = new JavaFXService();
		game.init(args);	
		
		
		//Orquestador orquestrador = new DefaultOrchestrator(juego, new DefaultGravity(), new DefaultBorrador(), new DefaultMovement(new DefaultMovementStrategy(new DefaultColisi)));
	}
}

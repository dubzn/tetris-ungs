import configurator.Configurador;
import model.Juego;
import model.ModoJuego;
import model.Tablero;
import view.GameService;
import view.JavaFXService;

public class Main {

	public static void main(String[] args) {
		Tablero defaultTablero = new Tablero();
		Configurador config = new Configurador(defaultTablero, ModoJuego.SUPERVIVENCIA);
		Juego juego = config.inicializar();
		
		GameService game = new JavaFXService();
		
		game.init(args);
	}

}

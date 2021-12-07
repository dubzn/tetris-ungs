import configurator.Configurador;
import model.Juego;
import model.ModoJuego;
import model.Tablero;
import service.GameService;
import service.LitiEngineService;

public class Main {

	public static void main(String[] args) {
		Tablero defaultTablero = new Tablero();
		Configurador config = new Configurador(defaultTablero, ModoJuego.SUPERVIVENCIA);
		Juego juego = config.inicializar();
		
		GameService game = new LitiEngineService();
		game.init(args);
		game.start(juego);
	}

}

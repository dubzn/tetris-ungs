package service;

import de.gurkenlabs.litiengine.Game;
import model.Juego;

public class LitiEngineService implements GameService {

	public void init(String... args) {
		Game.init(args);
		Game.start();		
	}

	public void finish(Juego juego) {
		Game.exit();
	}

	public void render(Juego juego) {
		
	}

}

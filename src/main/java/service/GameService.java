package service;

import model.Juego;

public interface GameService {

	void init(Juego juego);
	void finish(Juego juego);
	void render(Juego juego);
}

package service;

import model.Juego;
import view.GameViewService;

public class ConsoleViewService implements GameViewService {

	@Override
	public void init(String... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Juego juego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Juego juego) {
		System.out.println(juego.getTablero());
	}

}

package service;

import model.Juego;

public class DefaultPuntaje implements PuntajeService {

	@Override
	public void sumar(Juego partida, Integer lineas) {
		partida.setPuntaje(partida.getPuntaje()+lineas*10);
	}

}

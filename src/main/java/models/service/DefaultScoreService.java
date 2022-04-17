package models.service;

import models.Game;

public class DefaultScoreService implements ScoreService {

	@Override
	public void add(Game partida, Integer lines) {
		partida.setScore(partida.getScore() + lines * 10);
	}

}

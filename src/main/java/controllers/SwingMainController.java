package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import dtos.SquareDTO;
import models.Game;
import models.GameState;
import models.Movement;
import views.SwingGameView;

public class SwingMainController implements Observer {

	private ModelMapper mapper; 
	private final SwingKeyboardController keyboardController;
	private SwingGameView gameView;
	
	public SwingMainController(SwingKeyboardController keyboardController, SwingGameView swingGameView ) {
		this.mapper = new ModelMapper();
		this.gameView = swingGameView;
		this.keyboardController = keyboardController;
	}

	public void start() {
		addKeyBoardListeners();
		gameView.setVisible(true);
	}


	@Override
	public void update(Observable o, Object arg) {
		Game game = (Game) arg;
		if (GameState.FINISH.equals(game.getGameState())) {
			gameView.showGameOver();
			return;
		}
		List<SquareDTO> actualTetrominoSquares = mapper.map(game.getBoard().getSquares(), new TypeToken<List<SquareDTO>>() {}.getType());
		List<SquareDTO> nextTetrominoSquares = mapper.map(game.getNextInGameTetromino().getSquareListForm(), new TypeToken<List<SquareDTO>>() {}.getType());
		gameView.update(actualTetrominoSquares, nextTetrominoSquares, game.getScore().toString());
	}

	public void addMovement(Integer keycode) {
		switch(keycode) {
		case 32:
			keyboardController.addMovement(Movement.ROTATE);
			break;
		case 37:
			keyboardController.addMovement(Movement.LEFT);
			break;
		case 39: 
			keyboardController.addMovement(Movement.RIGHT);
			break;
		case 40:
			keyboardController.addMovement(Movement.DOWN);
			break;	
		}
	}
	
	private void addKeyBoardListeners() {
		gameView.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				addMovement(e.getKeyCode());
			}
		});
	}
}

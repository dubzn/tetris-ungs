package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import dto.SquareDTO;
import model.Game;
import model.GameState;
import model.Movement;
import view.GameViewService;
import view.SwingGameView;

public class SwingMainController implements GameViewService {

	private ModelMapper mapper; 
	private final SwingKeyboardController keyboardController;
	private SwingGameView gameView;
	
	public SwingMainController(SwingKeyboardController keyboardController) {
		this.mapper = new ModelMapper();
		this.keyboardController = keyboardController;
	}

	@Override
	public void start() {
		gameView = new SwingGameView();
		addKeyBoardListeners();
		gameView.setVisible(true);
	}

	@Override
	public void update(Game game) {
		if(game.getGameState().equals(GameState.FINISH)) {
			gameView.showGameOver();
			return;
		}
		List<SquareDTO> actualTetrominoSquares = mapper.map(game.getBoard().getAllSquares(), new TypeToken<List<SquareDTO>>() {}.getType());
		List<SquareDTO> nextTetrominoSquares = mapper.map(game.getNextInGameTetromino().getSquareListForm(), new TypeToken<List<SquareDTO>>() {}.getType());
		gameView.update(actualTetrominoSquares, nextTetrominoSquares, game.getScore().toString());
	}
	

	@Override
	public void finish(Game game) {
		gameView.close();
		
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

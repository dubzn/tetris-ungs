package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import dto.CeldaDTO;
import model.Juego;
import model.Movimiento;
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
	public void update(Juego juego) {
		List<CeldaDTO> celdasDTO = mapper.map(juego.getTablero().getCeldas(), new TypeToken<List<CeldaDTO>>() {}.getType());
		gameView.update(celdasDTO);
	}
	

	@Override
	public void finish(Juego juego) {
		gameView.close();
		
	}
	
	public void addMovement(Integer keycode) { 
		switch(keycode) {
		case 32:
			keyboardController.addMovement(Movimiento.ROTAR);
			break;
		case 37:
			keyboardController.addMovement(Movimiento.IZQUIERDA);
			break;
		case 39: 
			keyboardController.addMovement(Movimiento.DERECHA);
			break;
		case 40:
			keyboardController.addMovement(Movimiento.ABAJO);
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

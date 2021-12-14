package service;

import java.util.Objects;

import factory.PiezaFactory;
import model.Game;
import model.Tetromino;
import model.InGameTetromino;
import model.Position;
import view.GameViewService;

public class DefaultOrchestrator implements Orquestador {

	private Game partida;
	private final LineCleanerService borrador;
	private final GameViewService view;
	private final GravityService gravedad;
	private final MovementService movimiento;
	private final PiezaFactory factory;
	private TimeService time;
	
	public DefaultOrchestrator(Game partida, LineCleanerService borrador, GravityService gravedad,
			GameViewService view, MovementService movimiento, PiezaFactory generador) {

		this.partida = partida;
		this.borrador = borrador;
		this.gravedad = gravedad;
		this.view = view;
		this.movimiento = movimiento;
		this.factory = generador;

		this.time = new TimeService();
	}

	public void run() {
		try {
			System.out.println("Time: "+time.getTimeInSeconds());
			partida.setInGameTetromino(updateInGameTetromino());

			//System.out.println(partida.getPiezaEnJuego().getNombre() + " position: x=" + partida.getPiezaEnJuego().getX()
			//				+ " y=" + partida.getPiezaEnJuego().getY() + " alto: " + partida.getPiezaEnJuego().getAlto()
			//				+ " floating: " + partida.getPiezaEnJuego().getEstado().getEstaFlotando());

			// check if player do a movement
			partida = movimiento.run(partida);

			if(time.getTimeInSeconds() % partida.getGravityVelocity() == 0) {
				partida = gravedad.run(partida);	
			}
			
			if(!partida.getInGameTetromino().getState().getIsFloating()) {
				partida = borrador.run(partida);
			}

			view.update(partida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private InGameTetromino updateInGameTetromino() {
		if (Objects.isNull(partida.getInGameTetromino())) {
			System.out.println("Pieza en juego es null creando una nueva");
			return createTetrominoInPosition(5, 1);
		}

		if (!partida.getInGameTetromino().getState().getIsFloating()) {
			System.out.println("La pieza ya no esta flotando creando una nueva");
			return createTetrominoInPosition(5, 1);
		}

		return partida.getInGameTetromino();
	}

	private InGameTetromino createTetrominoInPosition(Integer x, Integer y) {
		Tetromino tetromino = factory.createRandom();
		return new InGameTetromino(tetromino.getName(), new Position(x, y), tetromino.getHorizontalForm(),
				tetromino.getVerticalForm());
	}

}

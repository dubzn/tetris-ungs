package service;

import java.util.List;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Juego;
import model.Movimiento;
import model.Orientacion;

public class DefaultColisionService implements ColisionService {


	@Override
	public boolean canRotate(Juego juego) throws CeldaNotFoundException {
		appearPiezaEnJuego(juego, false);
		boolean ret = true;
		appearPiezaEnJuego(juego, true);

		return ret;
	}
	
	@Override
	public boolean canMove(Juego juego, Movimiento movimiento) throws CeldaNotFoundException {
		appearPiezaEnJuego(juego, false);
		boolean ret = !colisionaConBorde(juego, movimiento) && !colisionaConPieza(juego, movimiento);
		appearPiezaEnJuego(juego, true);

		return ret;
	}

	private void appearPiezaEnJuego(Juego juego, boolean appear) throws CeldaNotFoundException {
		List<Celda> celdasPieza = juego.getPiezaEnJuego().getEstado().getOrientacion().equals(Orientacion.HORIZONTAL)
				? juego.getPiezaEnJuego().getPiezaHorizontal()
				: juego.getPiezaEnJuego().getPiezaVertical();

		for (Celda celda : celdasPieza) {
			juego.getTablero().getCelda(celda.getX() + juego.getPiezaEnJuego().getX(),
					celda.getY() + juego.getPiezaEnJuego().getY()).setOcupada(appear);
		}
	}

	private boolean colisionaConPieza(Juego juego, Movimiento movimiento) {
		List<Celda> celdasPieza = juego.getPiezaEnJuego().getEstado().getOrientacion().equals(Orientacion.HORIZONTAL)
				? juego.getPiezaEnJuego().getPiezaHorizontal()
				: juego.getPiezaEnJuego().getPiezaVertical();

		return celdasPieza.stream().anyMatch(celda -> resolve(juego, celda, movimiento));
	}

	private boolean resolve(Juego juego, Celda celda, Movimiento movimiento) {
		try {
			return juego.getTablero()
					.getCelda(celda.getX() + juego.getPiezaEnJuego().getX() + movimiento.getMovementX(),
							celda.getY() + juego.getPiezaEnJuego().getY() + movimiento.getMovementY())
					.getOcupada();
		} catch (CeldaNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean colisionaConBorde(Juego juego, Movimiento movimiento) {
		switch (movimiento) {
		case IZQUIERDA:
			return !(juego.getPiezaEnJuego().getX() + movimiento.getMovementX() >= 1);
		case DERECHA:
			return !(juego.getPiezaEnJuego().getX() + juego.getPiezaEnJuego().getAncho() <= juego.getTablero().getAncho());
		case ABAJO:
			return !(juego.getPiezaEnJuego().getY() + juego.getPiezaEnJuego().getAlto() <= juego.getTablero().getAlto());
		default:
			return false;
		}
	}


}

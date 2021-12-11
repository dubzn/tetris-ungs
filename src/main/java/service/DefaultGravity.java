package service;

import java.util.ArrayList;
import java.util.List;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Juego;
import model.Movimiento;
import model.Orientacion;
import model.Position;
import model.Tablero;

public class DefaultGravity implements GravedadService {
	
	private final ColisionService colision;
	
	public DefaultGravity(ColisionService colision) {
		this.colision = colision;
	}
	
	public Juego run(Juego juego) throws CeldaNotFoundException {
		System.out.println("#GRAVEDAD SERVICE#");
		

		
		if(juego.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			appearPiezaEnJuego(juego, false);
			aplicarGravedadAPiezaEnJuego(juego);	
			appearPiezaEnJuego(juego, true);
		}

		return juego;
	}

	private void appearPiezaEnJuego(Juego juego, boolean appear) throws CeldaNotFoundException {	
		List<Celda> celdasPieza = juego.getPiezaEnJuego()
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? juego.getPiezaEnJuego().getPiezaHorizontal() : juego.getPiezaEnJuego().getPiezaVertical();
		
		for(Celda celda : celdasPieza) {
			juego.getTablero().getCelda(celda.getX() + juego.getPiezaEnJuego().getX(), celda.getY() + juego.getPiezaEnJuego().getY()).setOcupada(appear);
		}
	}
	
	private void aplicarGravedadAPiezaEnJuego(Juego juego) throws CeldaNotFoundException {
		/*List<Celda> celdasPieza = juego.getPiezaEnJuego()
					 .getEstado()
					 .getOrientacion()
					 .equals(Orientacion.HORIZONTAL) ? juego.getPiezaEnJuego().getPiezaHorizontal() : juego.getPiezaEnJuego().getPiezaVertical();
	
		if(colision.canMove(juego, Movimiento.ABAJO)) {
		//if(juego.getPiezaEnJuego().getY() + juego.getPiezaEnJuego().getAlto() <= juego.getTablero().getAlto()) { 
			for(Celda celda : celdasPieza) {
				Integer positionCandidateY = celda.getY() + juego.getPiezaEnJuego().getY() + 1;
				System.out.println("dibujando en posicion x="+celda.getX() + juego.getPiezaEnJuego().getX()+" y="+positionCandidateY);
				juego.getTablero().getCelda(celda.getX() + juego.getPiezaEnJuego().getX(), positionCandidateY).setOcupada(true);
			}
		} 
		
		if(juego.getPiezaEnJuego().getY() + juego.getPiezaEnJuego().getAlto() > juego.getTablero().getAlto()) {
			System.out.println("Equals, not floating anymore");
			juego.getPiezaEnJuego().getEstado().setEstaFlotando(false);
			return;
		}*/
		
		if(juego.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			System.out.println("setting new position: " + new Position(juego.getPiezaEnJuego().getX(), juego.getPiezaEnJuego().getY() + 1));
			juego.getPiezaEnJuego().setPosition(new Position(juego.getPiezaEnJuego().getX(), juego.getPiezaEnJuego().getY() + 1));	
		}
		
		if(!colision.canMove(juego, Movimiento.ABAJO)) {
			System.out.println("Equals, not floating anymore");
			juego.getPiezaEnJuego().getEstado().setEstaFlotando(false);	
		}
	}

	private void aplicarGravedadAlTablero(Juego juego) throws CeldaNotFoundException { 
		if(!juego.getPiezaEnJuego().getEstado().getEstaFlotando()) {
			Tablero tablero = juego.getTablero();
			List<Celda> afectadas = new ArrayList<Celda>();
			for(int posX = tablero.getAncho(); posX >= 1; posX --) {
				for(int posY = tablero.getAlto() - 1; posY >= 1; posY --) {
					Celda celdaDebajo = tablero.getCelda(posX, posY + 1);
					if(tablero.getCelda(posX, posY).estaOcupada() && !afectadas.contains(tablero.getCelda(posX, posY))) {
						afectadas.add(celdaDebajo);
						if(!celdaDebajo.estaOcupada()) {
							tablero.getCelda(posX, posY).setOcupada(false);
							celdaDebajo.setOcupada(true);
						}
					}
				}
			}	
		}
	}

	private void removePiezaEnJuego(Juego juego) throws CeldaNotFoundException {		
		List<Celda> celdasPieza = juego.getPiezaEnJuego()
				 .getEstado()
				 .getOrientacion()
				 .equals(Orientacion.HORIZONTAL) ? juego.getPiezaEnJuego().getPiezaHorizontal() : juego.getPiezaEnJuego().getPiezaVertical();
		
		for(Celda celda : celdasPieza) {
			System.out.println("borrando: x="+(celda.getX() + juego.getPiezaEnJuego().getX())+" y="+(celda.getY() + juego.getPiezaEnJuego().getY()));
			juego.getTablero().getCelda(celda.getX() + juego.getPiezaEnJuego().getX(), celda.getY() + juego.getPiezaEnJuego().getY()).setOcupada(false);
		}
	}

}

package service;

import java.util.ArrayList;
import java.util.List;

import exception.CeldaNotFoundException;
import model.Celda;
import model.Tablero;

public class DefaultGravity implements GravedadService {

	public Tablero run(Tablero tablero) throws CeldaNotFoundException {
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
		return tablero;
	}

}

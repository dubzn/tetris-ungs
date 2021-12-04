package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Celda;
import model.Tablero;

public class DefaultGravity implements GravedadService {

	public Tablero run(Tablero tablero) {
		List<Celda> afectadas = new ArrayList<Celda>();
		for(int posX = tablero.getAncho(); posX >= 1; posX --) {
			for(int posY = tablero.getAlto(); posY >= 1; posY --) {
				Optional<Celda> celdaDebajo = tablero.getCelda(posX, posY+1);
				
				if(!celdaDebajo.isPresent()) {
					continue;
				}
				
				if(tablero.getCelda(posX, posY).get().estaOcupada() && !afectadas.contains(tablero.getCelda(posX, posY).get())) {
					afectadas.add(celdaDebajo.get());
					if(!celdaDebajo.get().estaOcupada()) {
						tablero.getCelda(posX, posY).get().setOcupada(false);
						celdaDebajo.get().setOcupada(true);
					}
				}
			}
		}

		return tablero;
	}

}

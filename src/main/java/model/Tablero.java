package model;

import java.util.ArrayList;
import java.util.List;

import exception.CeldaNotFoundException;

public class Tablero {
	private List<Celda> celdas;
	private final Integer ancho = 10;
	private final Integer alto = 22;
	
	public Tablero()  {
		//La cantidad de celdas que tiene el tablero ya están pre-definidas 22 alto * 10 ancho
		this.celdas = new ArrayList<Celda>();
		for(int posY = 1; posY<=alto; posY++) {
			for(int posX = 1; posX<=ancho; posX++) {
				this.celdas.add(new Celda(new Position(posX, posY), false));
			}
		}
	}
	
	public Integer getAlto() {
		return alto;
	}
	
	public Integer getAncho() {
		return ancho;
	}
	
	public List<Celda> getCeldas() {
		return celdas;
	}
	
	public void setCeldas(List<Celda> celdas) {
		this.celdas = celdas;
	}
	
	public Celda getCelda(Integer x, Integer y) throws CeldaNotFoundException {
		return celdas
			.stream()
			.filter(celda -> celda.getX() == x && celda.getY() == y)
			.findFirst()
			.orElseThrow(() -> new CeldaNotFoundException("La celda con posiciones (X: " + x + "Y: "+ y +") no corresponde al tablero de " + ancho + " de ancho y " + alto + "de alto"));
	}

	@Override
	public String toString() {
		String ret = "▒▒▒Tetris▒▒▒\n";
		ret = ret + "00123456789X\n";
		for(Celda celda : celdas) {
			if(celda.getX() == 1) {
				ret = celda.getY() >= 10 ? ret + + celda.getY() : ret +"0" + celda.getY();
			}
			String ocupada = celda.estaOcupada() ? "█" : "░";
			ret = ret + ocupada;
			if(celda.getX() == ancho) {
				ret = ret +"\n";
			}
		}
		
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alto == null) ? 0 : alto.hashCode());
		result = prime * result + ((ancho == null) ? 0 : ancho.hashCode());
		result = prime * result + ((celdas == null) ? 0 : celdas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		if (alto == null) {
			if (other.alto != null)
				return false;
		} else if (!alto.equals(other.alto))
			return false;
		if (ancho == null) {
			if (other.ancho != null)
				return false;
		} else if (!ancho.equals(other.ancho))
			return false;
		if (celdas == null) {
			if (other.celdas != null)
				return false;
		} else if (!celdas.equals(other.celdas))
			return false;
		return true;
	}
	
	
	
}

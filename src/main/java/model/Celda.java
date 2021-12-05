package model;

public class Celda {
	private Position posicion;
	private Boolean ocupada;

	public Celda(Position posicion, Boolean ocupada) {
		this.posicion = posicion;
		this.ocupada = ocupada;
	}
	
	public Integer getX() {
		return posicion.getX();
	}
	public void setX(Integer x) {
		this.posicion.setX(x);
	}
	public Integer getY() {
		return this.posicion.getY();
	}
	public void setY(Integer y) {
		this.posicion.setY(y);
	}
	
	public Boolean estaOcupada() {
		return ocupada;
	}
	
	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		String strOcupada = this.ocupada ? "X" : "O"; 
		return "C ["+ posicion.getX() + ", " + posicion.getY() + ", " + strOcupada + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ocupada == null) ? 0 : ocupada.hashCode());
		result = prime * result + ((posicion.getX() == null) ? 0 : posicion.getX().hashCode());
		result = prime * result + ((posicion.getY() == null) ? 0 : posicion.getY().hashCode());
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
		Celda other = (Celda) obj;
		if (ocupada == null) {
			if (other.ocupada != null)
				return false;
		} else if (!ocupada.equals(other.ocupada))
			return false;
		if (posicion.getX() == null) {
			if (other.posicion.getX() != null)
				return false;
		} else if (!posicion.getX().equals(other.posicion.getX()))
			return false;
		if (posicion.getY() == null) {
			if (other.posicion.getY() != null)
				return false;
		} else if (!posicion.getY().equals(other.posicion.getY()))
			return false;
		return true;
	}
	
	
}

package model;

public class Celda {
	private Integer x;
	private Integer y;
	private Boolean ocupada;

	public Celda(Integer x, Integer y, Boolean ocupada) {
		this.x = x;
		this.y = y;
		this.ocupada = ocupada;
	}
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
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
		return "C ["+ x + ", " + y + ", " + strOcupada + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ocupada == null) ? 0 : ocupada.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	
}

package model;

public class Square {
	
	private Position position;
	private Boolean occupied;

	public Square(Position position, Boolean occupied) {
		this.position = position;
		this.occupied = occupied;
	}
	
	public Integer getX() {
		return position.getX();
	}
	public void setX(Integer x) {
		this.position.setX(x);
	}
	public Integer getY() {
		return this.position.getY();
	}
	public void setY(Integer y) {
		this.position.setY(y);
	}
	
	public Boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		String strOcupada = this.occupied ? "X" : "O"; 
		return "C ["+ position.getX() + ", " + position.getY() + ", " + strOcupada + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((occupied == null) ? 0 : occupied.hashCode());
		result = prime * result + ((position.getX() == null) ? 0 : position.getX().hashCode());
		result = prime * result + ((position.getY() == null) ? 0 : position.getY().hashCode());
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
		Square other = (Square) obj;
		if (occupied == null) {
			if (other.occupied != null)
				return false;
		} else if (!occupied.equals(other.occupied))
			return false;
		if (position.getX() == null) {
			if (other.position.getX() != null)
				return false;
		} else if (!position.getX().equals(other.position.getX()))
			return false;
		if (position.getY() == null) {
			if (other.position.getY() != null)
				return false;
		} else if (!position.getY().equals(other.position.getY()))
			return false;
		return true;
	}
	
	
}

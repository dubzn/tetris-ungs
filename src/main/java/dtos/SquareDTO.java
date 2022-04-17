package dtos;

public class SquareDTO {

	private Integer x;
	private Integer y;
	private Boolean occupied;
	
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
	
	public Boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "CeldaDTO [x=" + x + ", y=" + y + ", occupied=" + occupied + "]";
	}
	
}

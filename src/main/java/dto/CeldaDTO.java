package dto;

public class CeldaDTO {

	private Integer x;
	private Integer y;
	private Boolean ocupada;
	
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
	
	public Boolean getOcupada() {
		return ocupada;
	}
	
	public void setOcupada(Boolean ocupada) {
		this.ocupada = ocupada;
	}

	@Override
	public String toString() {
		return "CeldaDTO [x=" + x + ", y=" + y + ", ocupada=" + ocupada + "]";
	}
	
}

package model;

public class EstadoPieza {
	private Orientacion orientacion;
	private Boolean estaFlotando;
	
	public Orientacion getOrientacion() {
		return orientacion; 
	}
	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	public Boolean getEstaFlotando() {
		return estaFlotando;
	}
	public void setEstaFlotando(Boolean estaFlotando) {
		this.estaFlotando = estaFlotando;
	}
}

package model;

import java.util.List;

public class Pieza {
	private String nombre;
	private Boolean estaFlotando;
	private Orientacion orientacion;
	private List<Celda> piezaHorizontal;
	private List<Celda> piezaVertical;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getEstaFlotando() {
		return estaFlotando;
	}
	public void setEstaFlotando(Boolean estaFlotando) {
		this.estaFlotando = estaFlotando;
	}
	public Orientacion getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	public List<Celda> getPiezaHorizontal() {
		return piezaHorizontal;
	}
	public void setPiezaHorizontal(List<Celda> piezaHorizontal) {
		this.piezaHorizontal = piezaHorizontal;
	}
	public List<Celda> getPiezaVertical() {
		return piezaVertical;
	}
	public void setPiezaVertical(List<Celda> piezaVertical) {
		this.piezaVertical = piezaVertical;
	}
	
}

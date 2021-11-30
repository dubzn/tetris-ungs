package model;

import java.util.List;

public class Pieza {
	private String nombre;
	private EstadoPieza estado;
	private List<Celda> piezaHorizontal;
	private List<Celda> piezaVertical;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public EstadoPieza getEstado() {
		return estado;
	}
	public void setEstado(EstadoPieza estado) {
		this.estado = estado;
	}
	
}

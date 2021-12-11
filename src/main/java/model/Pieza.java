package model;

import java.util.List;

public class Pieza {
	private String nombre;
	private EstadoPieza estado;
	private List<Celda> piezaHorizontal;
	private List<Celda> piezaVertical;
	private Integer anchoHorizontal;
	private Integer altoHorizontal;
	private Integer anchoVertical;
	private Integer altoVertical;
	
	public Pieza(String nombre, List<Celda> piezaHorizontal, List<Celda> piezaVertical) {
		this.nombre = nombre;
		this.piezaHorizontal = piezaHorizontal;
		this.piezaVertical = piezaVertical;
		this.estado = new EstadoPieza(Orientacion.HORIZONTAL, true);

		this.anchoHorizontal = piezaHorizontal.stream().max((c1,c2) -> c1.getX().compareTo(c2.getX())).get().getX();
		this.altoHorizontal = piezaHorizontal.stream().max((c1,c2) -> c1.getY().compareTo(c2.getY())).get().getY();
		this.anchoVertical = piezaVertical.stream().max((c1,c2) -> c1.getX().compareTo(c2.getX())).get().getX();
		this.altoVertical = piezaVertical.stream().max((c1,c2) -> c1.getY().compareTo(c2.getY())).get().getY();
	}
	
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
	
	public Integer getAncho() {
		return estado.getOrientacion().equals(Orientacion.HORIZONTAL) ? anchoHorizontal : anchoVertical;
	}
	
	public Integer getAlto() {
		return estado.getOrientacion().equals(Orientacion.HORIZONTAL) ? altoHorizontal : altoVertical;
	}
	
	public EstadoPieza getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPieza estado) {
		this.estado = estado;
	}
	
}

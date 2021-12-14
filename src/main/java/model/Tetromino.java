package model;

import java.util.List;

public class Tetromino {
	
	private String name;
	private TetrominoState state;
	private List<Square> horizontalForm;
	private List<Square> verticalForm;
	private Integer horizontalWidth;
	private Integer horizontalHeight;
	private Integer verticalWidth;
	private Integer verticalHeight;
	
	public Tetromino(String name, List<Square> horizontalForm, List<Square> verticalForm) {
		this.name = name;
		this.horizontalForm = horizontalForm;
		this.verticalForm = verticalForm;
		this.state = new TetrominoState(Orientation.HORIZONTAL, true);

		this.horizontalWidth = horizontalForm.stream().max((c1,c2) -> c1.getX().compareTo(c2.getX())).get().getX()+1;
		this.horizontalHeight = horizontalForm.stream().max((c1,c2) -> c1.getY().compareTo(c2.getY())).get().getY()+1;
		this.verticalWidth = verticalForm.stream().max((c1,c2) -> c1.getX().compareTo(c2.getX())).get().getX()+1;
		this.verticalHeight = verticalForm.stream().max((c1,c2) -> c1.getY().compareTo(c2.getY())).get().getY()+1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Square> getHorizontalForm() {
		return horizontalForm;
	}
	
	public void setHorizontalForm(List<Square> piezaHorizontal) {
		this.horizontalForm = piezaHorizontal;
	}
	
	public List<Square> getVerticalForm() {
		return verticalForm;
	}
	
	public void setVerticalForm(List<Square> piezaVertical) {
		this.verticalForm = piezaVertical;
	}
	
	public Integer getWidth() {
		return state.getOrientation().equals(Orientation.HORIZONTAL) ? horizontalWidth : verticalWidth;
	}
	
	public Integer getHeight() {
		return state.getOrientation().equals(Orientation.HORIZONTAL) ? horizontalHeight : verticalHeight;
	}
	
	public TetrominoState getState() {
		return state;
	}
	
	public void setState(TetrominoState estado) {
		this.state = estado;
	}
	
}

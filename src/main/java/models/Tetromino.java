package models;

import java.util.Collections;
import java.util.List;

public class Tetromino {
	
	private String name;
	private TetrominoState state;

	private final List<Square> horizontalForm;
	private final List<Square> verticalForm;
	private final List<Square> invertedHorizontalForm;
	private final List<Square> invertedVerticalForm;

	private final Integer horizontalWidth;
	private final Integer horizontalHeight;
	private final Integer verticalWidth;
	private final Integer verticalHeight;
	
	public Tetromino(String name, List<Square> horizontalForm, List<Square> invertedHorizontalForm, List<Square> verticalForm, List<Square> invertedVerticalForm, TetrominoState state) {
		this.name = name;
		this.horizontalForm = horizontalForm;
		this.verticalForm = verticalForm;
		this.invertedHorizontalForm = invertedHorizontalForm;
		this.invertedVerticalForm = invertedVerticalForm;
		this.state = state;

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

	public List<Square> getVerticalForm() {
		return verticalForm;
	}
	
	public List<Square> getInvertedVerticalForm() {
		return invertedVerticalForm;
	}
	
	public List<Square> getHorizontalForm() {
		return horizontalForm;
	}
	
	public List<Square> getInvertedHorizontalForm() {
		return invertedHorizontalForm;
	}

	public void setNextRotateState() {
		switch(this.getState().getOrientation()) {
		case VERTICAL:
			this.getState().setOrientation(Orientation.INVERTED_HORIZONTAL);
			break;
		case INVERTED_HORIZONTAL:
			this.getState().setOrientation(Orientation.INVERTED_VERTICAL);
			break;
		case INVERTED_VERTICAL:
			this.getState().setOrientation(Orientation.HORIZONTAL);
			break;
		case HORIZONTAL: 
			this.getState().setOrientation(Orientation.VERTICAL);
			break;
		}
	}
	public List<Square> getNextRotateForm() { 
		switch(this.getState().getOrientation()) {
		case VERTICAL:
			return this.getInvertedHorizontalForm();
		case INVERTED_HORIZONTAL:
			return this.getInvertedVerticalForm();
		case INVERTED_VERTICAL:
			return this.getHorizontalForm();
		case HORIZONTAL: 
			return this.getVerticalForm();
		default:
			return Collections.emptyList();
		}
	}
	
	public List<Square> getSquareListForm() { 
		switch(this.getState().getOrientation()) {
		case HORIZONTAL: 
			return this.getHorizontalForm();
		case INVERTED_HORIZONTAL:
			return this.getInvertedHorizontalForm();
		case VERTICAL:
			return this.getVerticalForm();
		case INVERTED_VERTICAL:
			return this.getInvertedVerticalForm();
		default:
			return Collections.emptyList();
		}
	}
	
	public Integer getWidth() {
		return state.getOrientation().equals(Orientation.HORIZONTAL) || 
				state.getOrientation().equals(Orientation.INVERTED_HORIZONTAL)
				? horizontalWidth : verticalWidth;
	}
	
	public Integer getHeight() {
		return state.getOrientation().equals(Orientation.HORIZONTAL) || 
				state.getOrientation().equals(Orientation.INVERTED_HORIZONTAL)
				? horizontalHeight : verticalHeight;
	}
	
	public TetrominoState getState() {
		return state;
	}
}

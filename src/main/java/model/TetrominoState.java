package model;

public class TetrominoState {
	private Orientation orientation;
	private Boolean isFloating;
	
	public TetrominoState(Orientation orientation, Boolean isFloating) {
		this.orientation = orientation;
		this.isFloating = isFloating;
	}
	
	public Orientation getOrientation() {
		return orientation; 
	}
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public Boolean getIsFloating() {
		return isFloating;
	}
	
	public void setIsFloating(Boolean isFloating) {
		this.isFloating = isFloating;
	}
}

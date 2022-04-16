package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class InGameTetromino extends Tetromino {
	
	private Position position;
	
	public InGameTetromino(String name, Position position, Tetromino tetromino) {
		super(name, tetromino.getHorizontalForm(), tetromino.getInvertedHorizontalForm(), tetromino.getVerticalForm(), tetromino.getInvertedVerticalForm());
		this.setPosition(position);
	}

}

package models;

import lombok.Getter;

@Getter
public enum Movement {
	
	LEFT("left", -1, 0),
	RIGHT("right", 1, 0),
	DOWN("down", 0, 1),
	ROTATE("rotate", 0, 0);
	
	private String name;
	private Integer movX;
	private Integer movY;
	
	Movement(String name, Integer x, Integer y) {
		this.name = name;
		this.movX = x;
		this.movY = y;
	}
}

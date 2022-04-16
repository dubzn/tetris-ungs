package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class Position {
	
	private Integer x;
	private Integer y;
	
	public Position(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
}

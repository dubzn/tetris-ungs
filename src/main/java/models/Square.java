package models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class Square {
	private Position position;
	private Boolean occupied;

	public Integer getX() {
		return this.position.getX();
	}

	public Integer getY() {
		return this.position.getY();
	}
}

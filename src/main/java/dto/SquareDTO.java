package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SquareDTO {

	private Integer x;
	private Integer y;
	private Boolean occupied;
}

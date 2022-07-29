package models;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@ToString
public class TetrominoState {
	private Orientation orientation;
	private Boolean isFloating;
}

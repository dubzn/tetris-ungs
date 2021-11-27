package model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class Pieza {
	private String nombre;
	private Orientacion orientacion;
	private List<Celda> piezaHorizontal;
	private List<Celda> piezaVertical;
}

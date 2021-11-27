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

public class Juego {
	private Tablero tablero;
	private List<Pieza> piezas;
	private String modoJuego;
	private Integer puntaje;
}

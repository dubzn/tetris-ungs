package service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import exception.CeldaNotFoundException;
import model.Tablero;
import util.DummyTableroFactory;

public class DefaultGravityTest {

	private GravedadService gravedad;

	@Before
	public void setUp() {
		this.gravedad = new DefaultGravity();
	}

	@Test
	public void whenTableroHasAFullLineInAir_ThenExcecutingGravityServiceOneTimeShouldIncreaseOneYPosition()
			throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create(Arrays.asList(10));

		Tablero actual = gravedad.run(input);

		Tablero expected = DummyTableroFactory.create(Arrays.asList(11));

		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

	@Test
	public void whenTableroHasAFullLineInAirAndSomeInLine22_ThenExcecutingGravityServiceOneTimeShouldIncreaseOneYPosition() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create(Arrays.asList(10));
		input.getCelda(10, 21).setOcupada(true);
		input.getCelda(8, 22).setOcupada(true);

		Tablero actual = gravedad.run(input);

		Tablero expected = DummyTableroFactory.create(Arrays.asList(11));
		expected.getCelda(10, 22).setOcupada(true);
		expected.getCelda(8, 22).setOcupada(true);

		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

	@Test
	public void whenTableroHasSomeCellsOccupied_ThenExcecutingGravityServiceOneTi1meShouldIncreaseOneYPosition() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		input.getCelda(10, 1).setOcupada(true);
		input.getCelda(8, 3).setOcupada(true);
		input.getCelda(8, 4).setOcupada(true);
		input.getCelda(4, 21).setOcupada(true);
		
		Tablero actual = gravedad.run(input);

		Tablero expected = DummyTableroFactory.create();
		expected.getCelda(10, 2).setOcupada(true);
		expected.getCelda(8, 4).setOcupada(true);
		expected.getCelda(8, 5).setOcupada(true);
		expected.getCelda(4, 22).setOcupada(true);

		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

	@Test
	public void whenTableroHasAFullLine22_ThenExcecutingGravityServiceReturnsSameTablero() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create(Arrays.asList(22));

		Tablero actual = gravedad.run(input);

		Tablero expected = DummyTableroFactory.create(Arrays.asList(22));

		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

}

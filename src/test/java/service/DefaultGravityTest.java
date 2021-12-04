package service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.Tablero;
import util.DummyTableroFactory;

public class DefaultGravityTest {

	private GravedadService gravedad;
	
	@Before
	public void setUp() {
		this.gravedad = new DefaultGravity();
	}
	
	@Test
	public void whenTableroHasAFullLineInAir_ThenExcecutingGravityServiceOneTimeShouldIncreaseOneYPosition() {
		Tablero input = DummyTableroFactory.create(Arrays.asList(10));

		Tablero actual = gravedad.run(input);

		Tablero expected = DummyTableroFactory.create(Arrays.asList(11));
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void whenTableroHasAFullLineInAirAndSomeInLine22_ThenExcecutingGravityServiceOneTimeShouldIncreaseOneYPosition() {
		Tablero input = DummyTableroFactory.create(Arrays.asList(10));
		input.getCelda(10, 21).get().setOcupada(true);
		input.getCelda(8, 22).get().setOcupada(true);
		
		Tablero actual = gravedad.run(input);
		
		Tablero expected = DummyTableroFactory.create(Arrays.asList(11));		
		expected.getCelda(10, 22).get().setOcupada(true);
		expected.getCelda(8, 22).get().setOcupada(true);
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void whenTableroHasSomeCellsOccupied_ThenExcecutingGravityServiceOneTimeShouldIncreaseOneYPosition() {
		Tablero input = DummyTableroFactory.create();
		input.getCelda(10, 1).get().setOcupada(true);
		input.getCelda(8, 3).get().setOcupada(true);
		input.getCelda(8, 4).get().setOcupada(true);
		input.getCelda(4, 21).get().setOcupada(true);
		
		Tablero actual = gravedad.run(input);
		
		Tablero expected = DummyTableroFactory.create();		
		expected.getCelda(10, 2).get().setOcupada(true);
		expected.getCelda(8, 4).get().setOcupada(true);
		expected.getCelda(8, 5).get().setOcupada(true);
		expected.getCelda(4, 22).get().setOcupada(true);
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void whenTableroHasAFullLine22_ThenExcecutingGravityServiceReturnsSameTablero() {
		Tablero input = DummyTableroFactory.create(Arrays.asList(22));
		
		Tablero actual = gravedad.run(input);
		
		Tablero expected = DummyTableroFactory.create(Arrays.asList(22));		
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
}

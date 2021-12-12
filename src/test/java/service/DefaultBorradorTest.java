package service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.Tablero;
import util.DummyTableroFactory;

public class DefaultBorradorTest {

	private BorradorLineasService borrador;
	
	@Before
	public void setUp() {
		borrador = new DefaultBorradorService();
	}
	
	@Test
	public void whenTableroHasFullLines9And10_ThenReturnsATableroWithLines9And10Empty() {
		Tablero input = DummyTableroFactory.create(Arrays.asList(18, 21, 22));

		Tablero actual = borrador.run(input);
		
		Tablero expected = DummyTableroFactory.create();
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}	
	
	@Test
	public void whenTableroHasNoFullLines_ThenReturnsSameTablero() {
		Tablero input = DummyTableroFactory.create();
		input.getCeldas().get(10).setOcupada(true);
		input.getCeldas().get(11).setOcupada(true);
		
		Tablero actual = borrador.run(input);
		
		assertEquals(input.getCeldas(), actual.getCeldas());
	}	
	
	@Test
	public void whenTableroAlmostHasAFullLine_ThenReturnsSameTablero() {
		Tablero input = DummyTableroFactory.create(Arrays.asList(22));
		input.getCeldas().get(210).setOcupada(false);

		Tablero actual = borrador.run(input);
		
		assertEquals(input.getCeldas(), actual.getCeldas());
	}	
}

package service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import model.Board;
import util.DummyTableroFactory;

public class DefaultBorradorTest {

	private LineCleanerService borrador;
	
	@Before
	public void setUp() {
		borrador = new DefaultLineCleanerService();
	}
	
	@Test
	public void whenTableroHasFullLines9And10_ThenReturnsATableroWithLines9And10Empty() {
		Board input = DummyTableroFactory.create(Arrays.asList(18, 21, 22));

		Board actual = borrador.run(input);
		
		Board expected = DummyTableroFactory.create();
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}	
	
	@Test
	public void whenTableroHasNoFullLines_ThenReturnsSameTablero() {
		Board input = DummyTableroFactory.create();
		input.getAllSquares().get(10).setOccupied(true);
		input.getAllSquares().get(11).setOccupied(true);
		
		Board actual = borrador.run(input);
		
		assertEquals(input.getAllSquares(), actual.getAllSquares());
	}	
	
	@Test
	public void whenTableroAlmostHasAFullLine_ThenReturnsSameTablero() {
		Board input = DummyTableroFactory.create(Arrays.asList(22));
		input.getAllSquares().get(210).setOccupied(false);

		Board actual = borrador.run(input);
		
		assertEquals(input.getAllSquares(), actual.getAllSquares());
	}	
}

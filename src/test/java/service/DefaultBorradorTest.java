package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import model.service.ScoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exception.SquareNotFoundException;
import model.Board;
import model.Game;
import util.DummyTableroFactory;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBorradorTest {
	
	@Mock
	private ScoreService score;

	@InjectMocks
	private DefaultLineCleanerService borrador;
	
	@Before
	public void setUp() {
		borrador = new DefaultLineCleanerService(score);
	}
	
	@Test
	public void whenTableroHasFullLines1821And22_ThenReturnsATableroWithLines1821And22Empty() {
		Board board = DummyTableroFactory.create(Arrays.asList(18, 21, 22));
		Game input = new Game(board);
		
		Game actual = borrador.run(input);
		
		Game expected = new Game(DummyTableroFactory.create());
	    verify(score, times(3)).add(input, 1);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void whenTableroHasNoFullLines_ThenReturnsSameTablero() throws SquareNotFoundException {
		Board board = DummyTableroFactory.create();
		board.getSquare(10, 5).setOccupied(true);
		board.getSquare(10, 6).setOccupied(true);
		Game input = new Game(board);
		
		Game actual = borrador.run(input);
		board = DummyTableroFactory.create();
		board.getSquare(10, 5).setOccupied(true);
		board.getSquare(10, 6).setOccupied(true);
		Game expected = new Game(board);

	    verify(score, times(0)).add(input, 1);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void whenTableroAlmostHasAFullLine_ThenReturnsSameTablero() throws SquareNotFoundException {
		Board board = DummyTableroFactory.create(Arrays.asList(22));
		board.getSquare(10, 22).setOccupied(false);
		Game input = new Game(board);

		Game actual = borrador.run(input);
		
		board = DummyTableroFactory.create(Arrays.asList(22));
		board.getSquare(10, 22).setOccupied(false);
		Game expected = new Game(board);

	    verify(score, times(0)).add(input, 1);
		assertEquals(expected, actual);
	}	
}

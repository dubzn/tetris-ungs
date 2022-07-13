package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;

import models.InGameTetromino;
import models.Position;
import models.core.CleanerHandler;
import models.core.GravityHandler;
import models.service.ScoreService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exceptions.SquareNotFoundException;
import models.Board;
import models.Game;
import util.DummyBoardFactory;
import util.DummyPiezaFactory;

@RunWith(MockitoJUnitRunner.class)
public class CleanerTest {
	
	@Mock
	private ScoreService score;

	@InjectMocks
	private CleanerHandler cleaner;
	
	@Before
	public void setUp() {
		cleaner = new CleanerHandler(score);
	}
	
	@Test
	public void whenBoardHasFullLines1821And22_ThenReturnsABoardWithLines1821And22Empty() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create(Arrays.asList(18, 21, 22));
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(null, new Position(5, 1), DummyPiezaFactory.createO()));
		input.getInGameTetromino().getState().setIsFloating(false);

		cleaner.handle(input);

		Game expected = new Game(DummyBoardFactory.create());
		DummyBoardFactory.addTetromino(expected.getBoard(), new Position(5, 1), DummyPiezaFactory.createO());
		verify(score, times(3)).add(input, 1);
		assertEquals(expected.getBoard(), input.getBoard());
	}	
	
	@Test
	public void whenBoardHasNoFullLines_ThenReturnsSameBoard() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		board.getSquare(10, 5).setOccupied(true);
		board.getSquare(10, 6).setOccupied(true);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(null, new Position(5, 1), DummyPiezaFactory.createO()));
		input.getInGameTetromino().getState().setIsFloating(false);

		cleaner.handle(input);

		board = DummyBoardFactory.create();
		board.getSquare(10, 5).setOccupied(true);
		board.getSquare(10, 6).setOccupied(true);
		DummyBoardFactory.addTetromino(board, new Position(5, 1), DummyPiezaFactory.createO());
		board.getSquare(10, 22).setOccupied(false);
		Game expected = new Game(board);

		verify(score, times(0)).add(input, 1);
		assertEquals(expected.getBoard(), input.getBoard());
	}	
	
	@Test
	public void whenTableroAlmostHasAFullLine_ThenReturnsSameTablero() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create(Collections.singletonList(22));
		board.getSquare(10, 22).setOccupied(false);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(null, new Position(5, 1), DummyPiezaFactory.createO()));
		input.getInGameTetromino().getState().setIsFloating(false);

		cleaner.handle(input);
		
		board = DummyBoardFactory.create(Collections.singletonList(22));
		DummyBoardFactory.addTetromino(board, new Position(5, 1), DummyPiezaFactory.createO());
		board.getSquare(10, 22).setOccupied(false);
		Game expected = new Game(board);

		verify(score, times(0)).add(input, 1);
		assertEquals(expected.getBoard(), input.getBoard());
	}	
}

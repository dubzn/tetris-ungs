package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import models.core.GravityHandler;
import models.service.CollisionService;
import models.service.TimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exceptions.SquareNotFoundException;
import models.Game;
import models.InGameTetromino;
import models.Movement;
import models.Position;
import models.Tetromino;
import util.DummyPiezaFactory;
import util.DummyBoardFactory;

@RunWith(MockitoJUnitRunner.class)

public class GravityTest {

	private GravityHandler gravity;

	@Mock
	private CollisionService collision;

	@Mock
	private TimeService time;


	@Before
	public void setUp() {
		this.gravity = new GravityHandler(collision, time);
	}
	
	@Test
	public void whenATetrominoIsInPositionx5y1_ThenShouldReturnTheSameTetrominoInPositionx5y2() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyBoardFactory.withPieza(new Position(5, 1),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));
		
		when(collision.canMove(input, Movement.DOWN)).thenReturn(true);
		
		gravity.handle(input);
		
		Game expected = new Game(DummyBoardFactory.withPieza(new Position(5, 2),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 2), T));

		assertEquals(expected, input);
	}
	
	@Test
	public void whenATetrominoIsInPositionx5y22_ThenShouldReturnTheSameTetrominoInPositionx5y22() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyBoardFactory.withPieza(new Position(5, 21),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));
		
		when(collision.canMove(input, Movement.DOWN)).thenReturn(false);
		
		gravity.handle(input);
		
		Game expected = new Game(DummyBoardFactory.withPieza(new Position(5, 21),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));

		assertFalse(input.getInGameTetromino().getState().getIsFloating());
		assertEquals(expected, input);
	}
	
	@Test
	public void whenInGameTetrominoIsNotFloating_ThenShouldReturnSameBoard() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyBoardFactory.withPieza(new Position(5, 21),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));
		input.getInGameTetromino().getState().setIsFloating(false);
		
		gravity.handle(input);
		
		Game expected = new Game(DummyBoardFactory.withPieza(new Position(5, 21),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));

		verify(collision, times(0)).canMove(input, Movement.DOWN);
		assertFalse(input.getInGameTetromino().getState().getIsFloating());
		assertEquals(expected, input);
	}



}

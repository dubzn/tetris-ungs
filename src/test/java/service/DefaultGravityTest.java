package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exception.SquareNotFoundException;
import model.Game;
import model.InGameTetromino;
import model.Movement;
import model.Position;
import model.Tetromino;
import util.DummyPiezaFactory;
import util.DummyTableroFactory;

@RunWith(MockitoJUnitRunner.class)

public class DefaultGravityTest {

	private GravityService gravedad;

	@Mock
	private CollisionService colision;
	
	@Before
	public void setUp() {
		this.gravedad = new DefaultGravityService(colision);
	}
	
	@Test
	public void whenATetrominoIsInPositionx5y1_ThenShouldReturnTheSameTetrominoInPositionx5y2() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyTableroFactory.withPieza(new Position(5, 1),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));
		
		when(colision.canMove(input, Movement.DOWN)).thenReturn(true);
		
		Game actual = gravedad.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 2),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 2), T));

		assertEquals(expected, actual);
	}
	
	@Test
	public void whenATetrominoIsInPositionx5y22_ThenShouldReturnTheSameTetrominoInPositionx5y22() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyTableroFactory.withPieza(new Position(5, 21),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));
		
		when(colision.canMove(input, Movement.DOWN)).thenReturn(false);
		
		Game actual = gravedad.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 21),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));

		assertFalse(actual.getInGameTetromino().getState().getIsFloating());
		assertEquals(expected, actual);
	}
	
	@Test
	public void whenInGameTetrominoIsNotFloating_ThenShouldReturnSameBoard() throws SquareNotFoundException {
		Tetromino T = DummyPiezaFactory.createT();
		Game input = new Game(DummyTableroFactory.withPieza(new Position(5, 21),  T));
		input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));
		input.getInGameTetromino().getState().setIsFloating(false);
		
		Game actual = gravedad.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 21),  T));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 21), T));

		verify(colision, times(0)).canMove(input, Movement.DOWN);
		assertFalse(actual.getInGameTetromino().getState().getIsFloating());
		assertEquals(expected, actual);
	}



}

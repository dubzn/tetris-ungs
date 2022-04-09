package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import exception.SquareNotFoundException;
import model.Movement;
import model.Tetromino;
import model.Position;
import model.Board;
import model.Game;
import model.InGameTetromino;
import util.DummyPiezaFactory;
import util.DummyTableroFactory;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMovementTest {

    @Mock
	private CollisionService colision;

    @InjectMocks
	private DefaultMovementService movement;
    
	@Before
	public void setUp() {
		movement = new DefaultMovementService(colision);
	}
	
	@Test
	public void moverLeftTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.LEFT)).thenReturn(true);

		movement.addToQueue(Movement.LEFT);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(4, 1), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(4, 1), T));

		assertEquals(expected, actual);
	}
	
	@Test
	public void cannotMoveLeftReturnsSameTableroTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.LEFT)).thenReturn(false);

		movement.addToQueue(Movement.LEFT);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));

		assertEquals(expected, actual);
	}
	
	@Test
	public void moveDownTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 4);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.DOWN)).thenReturn(true);

		movement.addToQueue(Movement.DOWN);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 5), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 5), T));

		assertEquals(expected, actual);
	}
	
	@Test
	public void cannotMoveDownTestReturnsSameTableroTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.DOWN)).thenReturn(false);

		movement.addToQueue(Movement.DOWN);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));

		assertEquals(expected, actual);
	}
	@Test
	public void moveRightTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 4);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.RIGHT)).thenReturn(true);

		movement.addToQueue(Movement.RIGHT);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(6, 4), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(6, 4), T));

		assertEquals(expected, actual);
	}
	
	@Test
	public void cannotMoveRightTestReturnsSameTableroTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board board = DummyTableroFactory.withPieza(initialPosition, T);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(T.getName(), initialPosition, T));
		when(colision.canMove(input, Movement.RIGHT)).thenReturn(false);

		movement.addToQueue(Movement.RIGHT);
		Game actual = movement.run(input);
		
		Game expected = new Game(DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT()));
		expected.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));

		assertEquals(expected, actual);
	}
}

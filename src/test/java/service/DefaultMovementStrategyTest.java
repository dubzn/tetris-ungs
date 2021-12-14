package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

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
import strategy.DefaultMovementStrategy;
import util.DummyPiezaFactory;
import util.DummyTableroFactory;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMovementStrategyTest {

    @Mock
	private CollisionService colision;

    @InjectMocks
	private DefaultMovementStrategy strategy;
    
	@Before
	public void setUp() {
		strategy = new DefaultMovementStrategy(colision);
	}
	
	@Test
	public void moverIzquierdaTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board input = DummyTableroFactory.withPieza(initialPosition, T);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(initialPosition, T);
		
		when(colision.canMove(input, initialPosition, T, Movement.LEFT)).thenReturn(true);
		
		Board actual = strategy.execute(input, piezaEnTablero, Movement.LEFT);
		
		Board expected = DummyTableroFactory.withPieza(new Position(4, 1), DummyPiezaFactory.createT());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}
	
	@Test
	public void cannotMoveIzquierdaReturnsSameTableroTest() throws SquareNotFoundException {
		Position initialPosition = new Position(5, 1);
		Tetromino T = DummyPiezaFactory.createT();
		Board input = DummyTableroFactory.withPieza(initialPosition, T);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(initialPosition, T);
		
		when(colision.canMove(input, initialPosition, T, Movement.LEFT)).thenReturn(false);
		
		Board actual = strategy.execute(input, piezaEnTablero, Movement.LEFT);
		
		Board expected = DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}
	
	@Test
	public void moverAbajoTest() throws SquareNotFoundException {
		Position position = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		Board input = DummyTableroFactory.withPieza(position, L);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, L);
		
		when(colision.canMove(input, position, L, Movement.DOWN)).thenReturn(true);
		
		Board actual = strategy.execute(input, piezaEnTablero, Movement.DOWN);
		
		Board expected = DummyTableroFactory.withPieza(new Position(5, 8), DummyPiezaFactory.createL());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}
	
	@Test
	public void cannotMoveAbajoReturnsSameTableroTest() throws SquareNotFoundException {
		Position position = new Position(1, 5);
		Tetromino O = DummyPiezaFactory.createO();
		Board input = DummyTableroFactory.withPieza(position, O);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, O);
		
		when(colision.canMove(input, position, O, Movement.DOWN)).thenReturn(false);
	
		Board actual = strategy.execute(input, piezaEnTablero, Movement.DOWN);
		
		Board expected = DummyTableroFactory.withPieza(new Position(1, 5), DummyPiezaFactory.createO());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}
	
	
	@Test
	public void moverDerechaTest() throws SquareNotFoundException {
		Position position = new Position(1, 7);
		Tetromino Z = DummyPiezaFactory.createZ();
		Board input = DummyTableroFactory.withPieza(position, Z);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, Z);
		System.out.println(input);
		when(colision.canMove(input, position, Z, Movement.RIGHT)).thenReturn(true);
		
		Board actual = strategy.execute(input, piezaEnTablero, Movement.RIGHT);
		System.out.println(actual);
		Board expected = DummyTableroFactory.withPieza(new Position(2, 7), DummyPiezaFactory.createZ());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}
	
	@Test
	public void cannotMoveDerechaReturnsSameTableroTest() throws SquareNotFoundException {
		Position position = new Position(1, 5);
		Tetromino L = DummyPiezaFactory.createL();
		Board input = DummyTableroFactory.withPieza(position, L);
		
		Map<Position, Tetromino> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, L);
		
		when(colision.canMove(input, position, L, Movement.RIGHT)).thenReturn(false);
		
		Board actual = strategy.execute(input, piezaEnTablero, Movement.RIGHT);
		
		Board expected = DummyTableroFactory.withPieza(new Position(1, 5), DummyPiezaFactory.createL());
		
		assertEquals(expected.getAllSquares(), actual.getAllSquares());
	}

}

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

import exception.CeldaNotFoundException;
import model.Movimiento;
import model.Pieza;
import model.Position;
import model.Tablero;
import strategy.DefaultMovementStrategy;
import util.DummyPiezaFactory;
import util.DummyTableroFactory;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMovementStrategyTest {

    @Mock
	private ColisionService colision;

    @InjectMocks
	private DefaultMovementStrategy strategy;
    
	@Before
	public void setUp() {
		strategy = new DefaultMovementStrategy(colision);
	}
	
	@Test
	public void moverIzquierdaTest() throws CeldaNotFoundException {
		Position initialPosition = new Position(5, 1);
		Pieza T = DummyPiezaFactory.createT();
		Tablero input = DummyTableroFactory.withPieza(initialPosition, T);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(initialPosition, T);
		
		when(colision.canMove(input, initialPosition, T, Movimiento.IZQUIERDA)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.IZQUIERDA);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(4, 1), DummyPiezaFactory.createT());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void cannotMoveIzquierdaReturnsSameTableroTest() throws CeldaNotFoundException {
		Position initialPosition = new Position(5, 1);
		Pieza T = DummyPiezaFactory.createT();
		Tablero input = DummyTableroFactory.withPieza(initialPosition, T);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(initialPosition, T);
		
		when(colision.canMove(input, initialPosition, T, Movimiento.IZQUIERDA)).thenReturn(false);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.IZQUIERDA);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void moverAbajoTest() throws CeldaNotFoundException {
		Position position = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		Tablero input = DummyTableroFactory.withPieza(position, L);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, L);
		
		when(colision.canMove(input, position, L, Movimiento.ABAJO)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.ABAJO);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(5, 8), DummyPiezaFactory.createL());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void cannotMoveAbajoReturnsSameTableroTest() throws CeldaNotFoundException {
		Position position = new Position(1, 5);
		Pieza O = DummyPiezaFactory.createO();
		Tablero input = DummyTableroFactory.withPieza(position, O);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, O);
		
		when(colision.canMove(input, position, O, Movimiento.ABAJO)).thenReturn(false);
	
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.ABAJO);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(1, 5), DummyPiezaFactory.createO());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	
	@Test
	public void moverDerechaTest() throws CeldaNotFoundException {
		Position position = new Position(1, 7);
		Pieza Z = DummyPiezaFactory.createZ();
		Tablero input = DummyTableroFactory.withPieza(position, Z);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, Z);
		System.out.println(input);
		when(colision.canMove(input, position, Z, Movimiento.DERECHA)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.DERECHA);
		System.out.println(actual);
		Tablero expected = DummyTableroFactory.withPieza(new Position(2, 7), DummyPiezaFactory.createZ());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void cannotMoveDerechaReturnsSameTableroTest() throws CeldaNotFoundException {
		Position position = new Position(1, 5);
		Pieza L = DummyPiezaFactory.createL();
		Tablero input = DummyTableroFactory.withPieza(position, L);
		
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		piezaEnTablero.put(position, L);
		
		when(colision.canMove(input, position, L, Movimiento.DERECHA)).thenReturn(false);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.DERECHA);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(1, 5), DummyPiezaFactory.createL());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

}

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
	public void moverIzquierdaTest() {
		Tablero input = DummyTableroFactory.withPieza(new Position(5, 1), DummyPiezaFactory.createT());
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		Pieza pieza = DummyPiezaFactory.createT();
		piezaEnTablero.put(new Position(5, 1), pieza);
		
		when(colision.canMove(input, piezaEnTablero, Movimiento.IZQUIERDA)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.IZQUIERDA);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(4, 1), DummyPiezaFactory.createT());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void moverAbajoTest() {
		Tablero input = DummyTableroFactory.withPieza(new Position(5, 7), DummyPiezaFactory.createL());
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		Pieza pieza = DummyPiezaFactory.createL();
		piezaEnTablero.put(new Position(5, 7), pieza);
		
		when(colision.canMove(input, piezaEnTablero, Movimiento.ABAJO)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.ABAJO);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(5, 8), DummyPiezaFactory.createL());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}
	
	@Test
	public void moverDerechaTest() {
		Tablero input = DummyTableroFactory.withPieza(new Position(1, 7), DummyPiezaFactory.createZ());
		Map<Position, Pieza> piezaEnTablero = new HashMap<>();
		Pieza pieza = DummyPiezaFactory.createZ();
		piezaEnTablero.put(new Position(1, 7), pieza);
		
		when(colision.canMove(input, piezaEnTablero, Movimiento.DERECHA)).thenReturn(true);
		
		Tablero actual = strategy.execute(input, piezaEnTablero, Movimiento.DERECHA);
		
		Tablero expected = DummyTableroFactory.withPieza(new Position(2, 7), DummyPiezaFactory.createZ());
		
		assertEquals(expected.getCeldas(), actual.getCeldas());
	}

}

package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import exception.CeldaNotFoundException;
import model.Movimiento;
import model.Pieza;
import model.Position;
import model.Tablero;
import util.DummyPiezaFactory;
import util.DummyTableroFactory;

public class DefaultColisionTest {

	private ColisionService colision;
	@Before
	public void setUp() {
		colision= new DefaultColisionService();
	}
	
	@Test
	public void canMoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 1), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 1), DummyPiezaFactory.createL());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(1, 1), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(1, 1), DummyPiezaFactory.createL());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		DummyTableroFactory.addPieza(input, new Position(4, 7), DummyPiezaFactory.createI());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(4, 7).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(4, 8).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda3MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(4, 9).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(4, 10).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.IZQUIERDA);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 1), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 1), DummyPiezaFactory.createL());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(9, 1), DummyPiezaFactory.createO());	
		DummyTableroFactory.addPieza(input, new Position(9, 1), DummyPiezaFactory.createO());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		DummyTableroFactory.addPieza(input, new Position(6, 7), DummyPiezaFactory.createI());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(6, 7).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(6, 8).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda3MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(7, 9).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(6, 10).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.DERECHA);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 1), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 1), DummyPiezaFactory.createL());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 21), DummyPiezaFactory.createO());	
		DummyTableroFactory.addPieza(input, new Position(5, 21), DummyPiezaFactory.createO());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		DummyTableroFactory.addPieza(input, new Position(5, 10), DummyPiezaFactory.createI());
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(5, 10).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(6, 10).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Map<Position, Pieza> piezaEnJuego = new HashMap<>();
		piezaEnJuego.put(new Position(5, 7), DummyPiezaFactory.createL());	
		DummyTableroFactory.addPieza(input, new Position(5, 7), DummyPiezaFactory.createL());
		input.getCelda(4, 10).setOcupada(true);
		
		boolean actual = colision.canMove(input, piezaEnJuego, Movimiento.ABAJO);

		assertTrue(actual);
	}
}

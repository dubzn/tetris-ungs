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
		Position initialPosition = new Position(5, 1);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, initialPosition, L);
		
		boolean actual = colision.canMove(input, initialPosition, L, Movimiento.IZQUIERDA);
		
		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position initialPosition = new Position(1, 1);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, initialPosition, L);
		
		boolean actual = colision.canMove(input, initialPosition, L, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(4, 7);
		Pieza L = DummyPiezaFactory.createL();
		Pieza I = DummyPiezaFactory.createI();
		
		DummyTableroFactory.addPieza(input, positionL, L);
		DummyTableroFactory.addPieza(input, positionI, I);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(4, 7).setOcupada(true);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);

		//Setting a single collision to check if can detect collision
		input.getCelda(4, 8).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda3MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);

		//Setting a single collision to check if can detect collision
		input.getCelda(4, 9).setOcupada(true);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.IZQUIERDA);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveIzquierdaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);

		//Setting a single collision to check if can detect collision
		input.getCelda(4, 10).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.IZQUIERDA);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 1);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(9, 1);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(6, 7);
		Pieza L = DummyPiezaFactory.createL();
		Pieza I = DummyPiezaFactory.createL();
		
		DummyTableroFactory.addPieza(input, positionL, L);
		DummyTableroFactory.addPieza(input, positionI, I);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(6, 7).setOcupada(true);
		
		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(6, 8).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda3MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(7, 9).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveDerechaTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(6, 10).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.DERECHA);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 1);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.ABAJO);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionO = new Position(5, 21);
		Pieza O = DummyPiezaFactory.createO();
		DummyTableroFactory.addPieza(input, positionO, O);

		boolean actual = colision.canMove(input, positionO, O, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(5, 10);
		Pieza L = DummyPiezaFactory.createL();
		Pieza I = DummyPiezaFactory.createL();
		
		DummyTableroFactory.addPieza(input, positionL, L);
		DummyTableroFactory.addPieza(input, positionI, I);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(5, 10).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(6, 10).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.ABAJO);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveAbajoTest() throws CeldaNotFoundException {
		Tablero input = DummyTableroFactory.create();
		Position positionL = new Position(5, 7);
		Pieza L = DummyPiezaFactory.createL();
		DummyTableroFactory.addPieza(input, positionL, L);
		
		//Setting a single collision to check if can detect collision
		input.getCelda(4, 10).setOcupada(true);

		boolean actual = colision.canMove(input, positionL, L, Movimiento.ABAJO);

		assertTrue(actual);
	}
}

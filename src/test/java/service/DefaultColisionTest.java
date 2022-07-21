package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exceptions.SquareNotFoundException;
import models.Movement;
import models.Tetromino;
import models.Position;
import models.Board;
import models.Game;
import models.InGameTetromino;
import util.DummyPiezaFactory;
import util.DummyBoardFactory;

public class DefaultColisionTest {

	private CollisionService colision;
	
	@Before
	public void setUp() {
		colision= new DefaultCollisionService();
	}
	
	@Test
	public void canMoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position initialPosition = new Position(5, 1);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, initialPosition, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), initialPosition, L));
		
		boolean actual = colision.canMove(input, Movement.LEFT);
		
		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position initialPosition = new Position(1, 1);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, initialPosition, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), initialPosition, L));
		
		boolean actual = colision.canMove(input, Movement.LEFT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(4, 7);
		Tetromino L = DummyPiezaFactory.createL();
		Tetromino I = DummyPiezaFactory.createI();
		
		DummyBoardFactory.addTetromino(board, positionL, L);
		DummyBoardFactory.addTetromino(board, positionI, I);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		boolean actual = colision.canMove(input, Movement.LEFT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(6, 7).setOccupied(true);
		
		boolean actual = colision.canMove(input, Movement.LEFT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda2MoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(4, 8).setOccupied(true);

		boolean actual = colision.canMove(input, Movement.LEFT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda3MoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(4, 8).setOccupied(true);
		
		boolean actual = colision.canMove(input, Movement.LEFT);

		assertFalse(actual);
	}
	
	@Test
	public void noColisionConCelda4MoveIzquierdaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(4, 10).setOccupied(true);

		boolean actual = colision.canMove(input, Movement.LEFT);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveDerechaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 1);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		boolean actual = colision.canMove(input, Movement.RIGHT);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveDerechaTest() throws SquareNotFoundException {
		Position positionL = new Position(8, 1);
		Tetromino L = DummyPiezaFactory.createL();
		
		Board board = DummyBoardFactory.withPieza(positionL, L);
		
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		boolean actual = colision.canMove(input, Movement.RIGHT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveDerechaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(6, 7);
		Tetromino L = DummyPiezaFactory.createL();
		Tetromino I = DummyPiezaFactory.createL();
		
		DummyBoardFactory.addTetromino(board, positionL, L);
		DummyBoardFactory.addTetromino(board, positionI, I);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		boolean actual = colision.canMove(input, Movement.RIGHT);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveDerechaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(8, 7).setOccupied(true);

		boolean actual = colision.canMove(input, Movement.RIGHT);

		assertFalse(actual);
	}
		
	@Test
	public void noColisionConCelda4MoveDerechaTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(6, 10).setOccupied(true);

		boolean actual = colision.canMove(input, Movement.RIGHT);

		assertTrue(actual);
	}
	
	@Test
	public void canMoveAbajoTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 1);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		boolean actual = colision.canMove(input, Movement.DOWN);

		assertTrue(actual);
	}
	
	@Test
	public void colisionConParedMoveAbajoTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionO = new Position(5, 21);
		Tetromino O = DummyPiezaFactory.createO();
		DummyBoardFactory.addTetromino(board, positionO, O);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(O.getName(), positionO, O));
		
		boolean actual = colision.canMove(input, Movement.DOWN);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConPiezaMoveAbajoTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Position positionI = new Position(5, 9);
		Tetromino L = DummyPiezaFactory.createL();
		Tetromino I = DummyPiezaFactory.createL();
		
		DummyBoardFactory.addTetromino(board, positionL, L);
		DummyBoardFactory.addTetromino(board, positionI, I);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		
		boolean actual = colision.canMove(input, Movement.DOWN);

		assertFalse(actual);
	}
	
	@Test
	public void colisionConCelda1MoveAbajoTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);

		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(5, 9).setOccupied(true);
		
		boolean actual = colision.canMove(input, Movement.DOWN);

		assertFalse(actual);
	}

	@Test
	public void noColisionConCelda4MoveAbajoTest() throws SquareNotFoundException {
		Board board = DummyBoardFactory.create();
		Position positionL = new Position(5, 7);
		Tetromino L = DummyPiezaFactory.createL();
		DummyBoardFactory.addTetromino(board, positionL, L);
		Game input = new Game(board);
		input.setInGameTetromino(new InGameTetromino(L.getName(), positionL, L));
		
		//Setting a single collision to check if can detect collision
		input.getBoard().getSquare(4, 10).setOccupied(true);

		boolean actual = colision.canMove(input,Movement.DOWN);

		assertTrue(actual);
	}
}

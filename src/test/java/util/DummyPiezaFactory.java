package util;

import java.util.Arrays;

import models.*;

public class DummyPiezaFactory {

	public static Tetromino createS() {
		return new Tetromino("S", 
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),

			new TetrominoState(Orientation.HORIZONTAL, true));
	}

	public static Tetromino createS(TetrominoState state) {
		return new Tetromino("S",
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true)),
			state);
	}

	public static Tetromino createZ() {
		return new Tetromino("Z", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 2), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 2), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}

	public static Tetromino createI() {
		return new Tetromino("I", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(0, 3), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(0, 3), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(3, 0), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(3, 0), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}

	public static Tetromino createL() {
		return new Tetromino("L", 
			Arrays.asList(
			new Square(new Position(2, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}

	public static Tetromino createL(TetrominoState state) {
		return new Tetromino("L",
			Arrays.asList(
			new Square(new Position(2, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)),
			state);
	}
	public static Tetromino createJ() {
		return new Tetromino("J", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true),
			new Square(new Position(0, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}

	public static Tetromino createT() {
		return new Tetromino("T", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(1, 1), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(1, 1), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}
	
	public static Tetromino createO() {
		return new Tetromino("O", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			new TetrominoState(Orientation.HORIZONTAL, true));
	}

}

package factory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import models.Square;
import models.Tetromino;
import models.Position;

public class ClassicTetrominoFactory implements TetrominoFactory {
	
	private List<Tetromino> classics;
	
	public ClassicTetrominoFactory() {
		this.classics = Arrays.asList(createS(), createI(), createZ(), createJ(), createT(), createO(), createL());
	}
	
	public Tetromino createRandom() {
		return this.classics.get(new Random().nextInt(classics.size()));
	}	

	public Tetromino createS() {
		return new Tetromino("S", 
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true)));		
	}

	public Tetromino createZ() {
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
			new Square(new Position(0, 2), true)));
	}

	public Tetromino createI() {
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
			new Square(new Position(3, 0), true)));
	}

	public Tetromino createL() {
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
			new Square(new Position(1, 2), true)));
	}

	public Tetromino createJ() {
		return new Tetromino("J", 
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(2, 0), true),
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true),
			new Square(new Position(0, 2), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(1, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true)));
	}

	public Tetromino createT() {
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
			new Square(new Position(2, 1), true)),
			Arrays.asList(
			new Square(new Position(1, 0), true),
			new Square(new Position(1, 1), true),
			new Square(new Position(1, 2), true),
			new Square(new Position(0, 1), true)),
			Arrays.asList(
			new Square(new Position(0, 0), true),
			new Square(new Position(0, 1), true),
			new Square(new Position(0, 2), true),
			new Square(new Position(1, 1), true)));
	}

	public Tetromino createO() {
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
			new Square(new Position(0, 1), true)));
	}

}

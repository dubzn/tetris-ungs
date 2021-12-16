package factory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Square;
import model.Tetromino;
import model.Position;

public class ClassicTetrisPiezaFactory implements PiezaFactory {
	
	private List<Tetromino> classics;
	
	public ClassicTetrisPiezaFactory() {
		this.classics = Arrays.asList(createS(), createI(), createZ(), createJ(), createT(), createO(), createL());
	}
	
	@Override
	public Tetromino createRandom() {
		return this.classics.get(new Random().nextInt(classics.size()));
	}	

	private Tetromino createS() {
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

	private Tetromino createZ() {
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

	private Tetromino createI() {
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

	private Tetromino createL() {
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

	private Tetromino createJ() {
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

	private Tetromino createT() {
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
	
	private Tetromino createO() {
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

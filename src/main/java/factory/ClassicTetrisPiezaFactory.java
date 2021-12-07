package factory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Celda;
import model.Pieza;
import model.Position;

public class ClassicTetrisPiezaFactory implements PiezaFactory {
	
	private List<Pieza> classics;
	
	public ClassicTetrisPiezaFactory() {
		this.classics = Arrays.asList(createS(), createI(), createZ(), createJ(), createT(), createO(), createL());
	}
	
	@Override
	public Pieza createRandom() {
		return this.classics.get(new Random().nextInt(classics.size()));
	}	


	private Pieza createS() {
		return new Pieza("S", 
				Arrays.asList(
				new Celda(new Position(1, 2), true),
				new Celda(new Position(2, 2), true),
				new Celda(new Position(2, 1), true),
				new Celda(new Position(3, 1), true)),
				Arrays.asList(
				new Celda(new Position(1, 1), true),
				new Celda(new Position(1, 2), true),
				new Celda(new Position(2, 2), true),
				new Celda(new Position(2, 3), true)));		
	}

	private Pieza createZ() {
		return new Pieza("Z", 
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(3, 2), true)),
			Arrays.asList(
			new Celda(new Position(2, 1), true),
			new Celda(new Position(1, 2), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(1, 3), true)));
	}

	private Pieza createI() {
		return new Pieza("I", 
				Arrays.asList(
				new Celda(new Position(1, 1), true),
				new Celda(new Position(1, 2), true),
				new Celda(new Position(1, 3), true),
				new Celda(new Position(1, 4), true)),
				Arrays.asList(
				new Celda(new Position(1, 1), true),
				new Celda(new Position(2, 1), true),
				new Celda(new Position(3, 1), true),
				new Celda(new Position(4, 1), true)));
	}

	private Pieza createL() {
		return new Pieza("L", 
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(1, 2), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(3, 2), true)),
			Arrays.asList(
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(2, 3), true),
			new Celda(new Position(1, 3), true)));
	}

	private Pieza createJ() {
		return new Pieza("J", 
			Arrays.asList(
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(2, 3), true),
			new Celda(new Position(1, 3), true)),
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(1, 2), true),
			new Celda(new Position(1, 3), true),
			new Celda(new Position(2, 3), true)));	
	}

	private Pieza createT() {
		return new Pieza("T", 
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(2, 1), true),
			new Celda(new Position(3, 1), true),
			new Celda(new Position(2, 2), true)),
			Arrays.asList(
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(2, 3), true),
			new Celda(new Position(1, 2), true)));
	}
	
	private Pieza createO() {
		return new Pieza("O", 
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(1, 2), true)),
			Arrays.asList(
			new Celda(new Position(1, 1), true),
			new Celda(new Position(2, 1), true),
			new Celda(new Position(2, 2), true),
			new Celda(new Position(1, 2), true)));
	}

}

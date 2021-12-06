package util;

import java.util.Arrays;

import model.Celda;
import model.Pieza;
import model.Position;

public class DummyPiezaFactory {
	
	// ###
	//  #
	public static Pieza createT() {
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
	
	// ##
	// ##
	public static Pieza createO() {
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
	
	// ##
	//  ##
	public static Pieza createZ() {
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
	
	// #
	// ###
	public static Pieza createL() {
		return new Pieza("L", 
				Arrays.asList(
				new Celda(new Position(1, 1), true),
				new Celda(new Position(1, 2), true),
				new Celda(new Position(2, 2), true),
				new Celda(new Position(3, 2), true)),
				Arrays.asList(
				new Celda(new Position(1, 1), true),
				new Celda(new Position(1, 2), true),
				new Celda(new Position(1, 3), true),
				new Celda(new Position(2, 3), true)));
		
	}
	
	// #
	// #
	// #
	// #
	public static Pieza createI() {
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
}

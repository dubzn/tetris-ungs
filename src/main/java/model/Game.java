package model;

import java.util.List;

import exception.SquareNotFoundException;

public class Game {
	
	private Board board;
	private InGameTetromino tetromino;
	private GameMode gamemode;
	private Integer score;
	private Integer gravityVelocity;
	
	public Game(Board board, GameMode gamemode) {
		this.board = board;
		this.gamemode = gamemode; 
		this.score = 0;
		//default gravity
		this.gravityVelocity = 1;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public InGameTetromino getInGameTetromino() {
		return this.tetromino;
	}
	
	public void setInGameTetromino(InGameTetromino tetromino) throws SquareNotFoundException {
		List<Square> celdasPieza = tetromino
				 .getState()
				 .getOrientation()
				 .equals(Orientation.HORIZONTAL) ? tetromino.getHorizontalForm() : tetromino.getVerticalForm();
				 
		for(Square celda : celdasPieza) {
			this.board.getSquare(celda.getX() + tetromino.getX(), celda.getY() + tetromino.getY()).setOccupied(true);
		}
		
		this.tetromino = tetromino;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public GameMode getModoJuego() {
		return gamemode;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getGravityVelocity() {
		return gravityVelocity;
	}

	public void setGravityVelocity(Integer gravityVelocity) {
		this.gravityVelocity = gravityVelocity;
	}

}

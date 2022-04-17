package models;

import java.util.List;
import exceptions.SquareNotFoundException;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Game {

  private Board board;
  private InGameTetromino tetromino;
  private Tetromino next;
  private GameState gameState;
  private Integer score;
  private Integer gravityVelocity;

  public Game(Board board) {
    this.board = board;
    this.score = 0;
    this.gameState = GameState.IN_PROGRESS;
    //default gravity
    this.gravityVelocity = 1;
  }

  public Board getBoard() {
    return board;
  }

  public Tetromino getNextInGameTetromino() {
    return this.next;
  }

  public void setNextInGameTetromino(Tetromino tetromino) throws SquareNotFoundException {
    this.next = tetromino;
  }

  public InGameTetromino getInGameTetromino() {
    return this.tetromino;
  }

  public boolean inGameTetrominoIsFloating() {
    return this.tetromino.getState().getIsFloating();
  }

  public void setInGameTetromino(InGameTetromino tetromino) throws SquareNotFoundException {
    List<Square> squares = tetromino.getSquareListForm();
    for(Square square : squares) {
      this.board.getSquare(square.getX() + tetromino.getX(), square.getY() + tetromino.getY()).setOccupied(true);
    }
    this.tetromino = tetromino;
  }

  public void setBoard(Board board) {
    this.board = board;
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

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  public boolean lastLinesAreOcuppied() {
    return this.board.getSquares().stream().anyMatch(square -> (square.getY() == 1 || square.getY() == 2) && square.getOccupied());
  }
}

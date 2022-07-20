package service;

import exceptions.SquareNotFoundException;
import models.*;
import models.core.GameStateHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import util.DummyBoardFactory;
import util.DummyPiezaFactory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameStateTest {

  private GameStateHandler gameState;

  @Before
  public void setUp() {
    this.gameState = new GameStateHandler();
  }

  @Test
  public void givingABoardWithLastLineOccupiedAndTetrominoInGameIsNotFloating_WhenHandlerRuns_ThenGameStateIsFINISH() throws SquareNotFoundException {
    Tetromino T = DummyPiezaFactory.createT();
    Game input = new Game(new Board());
    input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));
    input.getInGameTetromino().getState().setIsFloating(false);

    gameState.handle(input);

    assertEquals(input.getGameState(), GameState.FINISH);
  }

  @Test
  public void givingABoardWithLastLineOccupiedAndTetrominoInGameIsFloating_WhenHandlerRuns_ThenGameStateIsIN_PROGRESS() throws SquareNotFoundException {
    Tetromino T = DummyPiezaFactory.createT();
    Game input = new Game(new Board());
    input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 1), T));
    input.getInGameTetromino().getState().setIsFloating(true);

    gameState.handle(input);

    assertEquals(input.getGameState(), GameState.IN_PROGRESS);
  }

  @Test
  public void givingABoardWithOtherLinesOccupiedAndTetrominoInGameIsFloating_WhenHandlerRuns_ThenGameStateIsIN_PROGRESS() throws SquareNotFoundException {
    Tetromino T = DummyPiezaFactory.createT();
    Game input = new Game(new Board());
    input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 10), T));
    input.getInGameTetromino().getState().setIsFloating(true);

    gameState.handle(input);

    assertEquals(input.getGameState(), GameState.IN_PROGRESS);
  }

  @Test
  public void givingABoardWithOtherLinesOccupiedAndTetrominoInGameIsNotFloating_WhenHandlerRuns_ThenGameStateIsIN_PROGRESS() throws SquareNotFoundException {
    Tetromino T = DummyPiezaFactory.createT();
    Game input = new Game(DummyBoardFactory.create(Arrays.asList(21, 20)));
    input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 18), T));
    input.getInGameTetromino().getState().setIsFloating(false);

    gameState.handle(input);

    assertEquals(input.getGameState(), GameState.IN_PROGRESS);
  }
}

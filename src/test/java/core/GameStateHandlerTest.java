package core;

import exceptions.SquareNotFoundException;
import models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.DummyBoardFactory;
import util.DummyPiezaFactory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameStateHandlerTest {

  private GameStateHandler gameState;

  //Puede ser cualquier handler
  @Mock
  private CleanerHandler cleaner;

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

  @Test
  public void whenNextInHandlerIsntNull_ThenShouldBeCallToNextHandler() throws SquareNotFoundException {
    Tetromino T = DummyPiezaFactory.createT();
    Game input = new Game(DummyBoardFactory.create(Arrays.asList(21, 20)));
    input.setInGameTetromino(new InGameTetromino(T.getName(), new Position(5, 18), T));
    input.getInGameTetromino().getState().setIsFloating(false);

    GameStateHandler gameStateHandler = new GameStateHandler(cleaner);

    doNothing().when(cleaner).handle(input);
    gameStateHandler.handle(input);

    verify(cleaner, times(1)).handle(input);
  }
}

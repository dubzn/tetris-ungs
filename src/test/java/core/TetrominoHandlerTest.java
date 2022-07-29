package core;

import exceptions.SquareNotFoundException;
import factory.TetrominoFactory;
import models.Board;
import models.Game;
import models.InGameTetromino;
import models.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.DummyPiezaFactory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TetrominoHandlerTest {

  @Mock
  private TetrominoFactory factory;

  @Mock
  private GameStateHandler gameStateHandler;

  @InjectMocks
  private TetrominoHandler tetrominoHandler;

  @Before
  public void setUp() {
    this.tetrominoHandler = new TetrominoHandler(factory);
  }

  @Test
  @DisplayName("Giving null InGameTetromino then handler creates a new one and next")
  public void givingNullInGameTetromino_ThenHandlerCreateNewAndNext() {
    Game input = new Game(new Board());
    doReturn(DummyPiezaFactory.createT(), DummyPiezaFactory.createL()).when(factory).createRandom();

    tetrominoHandler.handle(input);

    assertEquals(DummyPiezaFactory.createT(), input.getNextInGameTetromino());
    assertEquals(new InGameTetromino("L", new Position(5, 1), DummyPiezaFactory.createL()), input.getInGameTetromino());
  }

  @Test
  @DisplayName("When next not null then calls to handle next action")
  public void whenNextIsNotNull_ThenCallsToHandleNextAction() {
    TetrominoHandler handler = new TetrominoHandler(gameStateHandler, factory);
    Game input = new Game(new Board());
    doReturn(DummyPiezaFactory.createT(), DummyPiezaFactory.createL()).when(factory).createRandom();
    doNothing().when(gameStateHandler).handle(input);

    handler.handle(input);

    verify(gameStateHandler, times(1)).handle(input);
  }

  @Test
  @DisplayName("Giving a Game with InGameTetromino then handler no creates a new one")
  public void givingAGameWithInGameTetromino_ThenHandlerNoCreatesANewOne() throws SquareNotFoundException {
    Game input = new Game(new Board());
    input.setInGameTetromino(new InGameTetromino("T",new Position(5, 5), DummyPiezaFactory.createT()));

    tetrominoHandler.handle(input);

    assertEquals(new InGameTetromino("T", new Position(5, 5), DummyPiezaFactory.createT()), input.getInGameTetromino());
  }

  @Test
  @DisplayName("Giving a Game with InGameTetromino but is not floating then handler creates a new one")
  public void givingAGameWithNonAFloatingInGameTetromino_ThenHandlerCreatesANewOne() throws SquareNotFoundException {
    Game input = new Game(new Board());
    input.setInGameTetromino(new InGameTetromino("T",new Position(5, 21), DummyPiezaFactory.createT()));
    input.getInGameTetromino().getState().setIsFloating(false);
    //The next one should be O tetromino
    input.setNextInGameTetromino(DummyPiezaFactory.createO());
    //Create a new one to replace the next
    doReturn(DummyPiezaFactory.createL()).when(factory).createRandom();

    tetrominoHandler.handle(input);

    assertEquals(new InGameTetromino("O", new Position(5, 1), DummyPiezaFactory.createO()), input.getInGameTetromino());
  }

}

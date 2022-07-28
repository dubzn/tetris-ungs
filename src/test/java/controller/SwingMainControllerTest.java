package controller;

import controllers.SwingKeyboardController;
import controllers.SwingMainController;
import dtos.SquareDTO;
import exceptions.SquareNotFoundException;
import models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.DummyBoardFactory;
import util.DummyPiezaFactory;
import views.SwingGameView;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SwingMainControllerTest {

  @Mock
  SwingKeyboardController keyboardController;

  @Mock
  SwingGameView gameView;

  @InjectMocks
  SwingMainController controller;

  @Before
  public void setUp() {
    controller = new SwingMainController(keyboardController, gameView);
  }

  @Test
  @DisplayName("When call start method then GameView add keyboard listeners")
  public void whenCallStartMethod_ThenGameViewAddKeyboardListeners() {
    doNothing().when(gameView).addKeyListener(any());

    controller.start();

    verify(gameView, times(1)).addKeyListener(any());
  }

  @Test
  @DisplayName("When call start method then GameView is visible")
  public void whenCallStartMethod_ThenGameViewSetVisibleOnTrue() {
    doNothing().when(gameView).addKeyListener(any());

    controller.start();

    verify(gameView, times(1)).setVisible(true);
  }

  @Test
  @DisplayName("Giving a game in progress when call update method then GameView calls update")
  public void givingAGameInProgress_whenCallUpdateMethod_ThenGameViewIsUpdated() throws SquareNotFoundException {
    Game input = new Game(DummyBoardFactory.create());
    input.setGameState(GameState.IN_PROGRESS);
    input.setNextInGameTetromino(DummyPiezaFactory.createL());
    input.setInGameTetromino(new InGameTetromino(DummyPiezaFactory.createT().getName(), new Position(5, 1), DummyPiezaFactory.createT()));

    controller.update(null, input);

    verify(gameView, times(1)).update(any(List.class), any(List.class), any(String.class));
  }

  @Test
  @DisplayName("Giving a game finished when call update method then GameView calls show game over")
  public void givingAGameFinished_whenCallUpdateMethod_ThenGameViewCallsGameOver() throws SquareNotFoundException {
    Game input = new Game(DummyBoardFactory.create());
    input.setGameState(GameState.FINISH);

    controller.update(null, input);

    verify(gameView, times(1)).showGameOver();
    verifyNoMoreInteractions(gameView);
  }

  @Test
  @DisplayName("Giving key code 32 when call addMovement function then keyboard controller should add ROTATE")
  public void givingKeyCode32_WhenCallAddMovementThenShouldAddROTATE() throws SquareNotFoundException {
    doNothing().when(keyboardController).addMovement(any());

    controller.addMovement(32);

    verify(keyboardController, times(1)).addMovement(Movement.ROTATE);
  }

  @Test
  @DisplayName("Giving key code 37 when call addMovement function then keyboard controller should add LEFT")
  public void givingKeyCode37_WhenCallAddMovementThenShouldAddLEFT() throws SquareNotFoundException {
    doNothing().when(keyboardController).addMovement(any());

    controller.addMovement(37);

    verify(keyboardController, times(1)).addMovement(Movement.LEFT);
  }

  @Test
  @DisplayName("Giving key code 39 when call addMovement function then keyboard controller should add RIGHT")
  public void givingKeyCode39_WhenCallAddMovementThenShouldAddRIGHT() throws SquareNotFoundException {
    doNothing().when(keyboardController).addMovement(any());

    controller.addMovement(39);

    verify(keyboardController, times(1)).addMovement(Movement.RIGHT);
  }

  @Test
  @DisplayName("Giving key code 40 when call addMovement function then keyboard controller should add DOWN")
  public void givingKeyCode40_WhenCallAddMovementThenShouldAddDOWN() throws SquareNotFoundException {
    doNothing().when(keyboardController).addMovement(any());

    controller.addMovement(40);

    verify(keyboardController, times(1)).addMovement(Movement.DOWN);
  }

  @Test
  @DisplayName("Giving a any other key code when call addMovement function then keyboard controller should not add movement")
  public void givingAnyOtherKeyCode_WhenCallAddMovementThenShouldNotAddMovement() throws SquareNotFoundException {
    controller.addMovement(100);

    verifyNoInteractions(keyboardController);
  }
}

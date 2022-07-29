package controller;

import controllers.SwingKeyboardController;
import core.MovementHandler;
import models.Movement;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.ControlService;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SwingKeyboardControllerTest {

  @Mock
  ControlService control;

  @InjectMocks
  SwingKeyboardController controller;

  @Before
  public void setUp() {
    this.controller = new SwingKeyboardController(control);
  }

  @Test
  @DisplayName("Giving RIGHT When call addMovement method then call addMovement ControlService method")
  public void whenCallAddMovement_ThenCallServiceMethod() {
    doNothing().when(control).addMovement(Movement.RIGHT);

    controller.addMovement(Movement.RIGHT);

    verify(control, times(1)).addMovement(Movement.RIGHT);
  }
}

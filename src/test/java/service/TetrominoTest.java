package service;

import factory.TetrominoFactory;
import models.core.GameStateHandler;
import models.core.TetrominoHandler;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TetrominoTest {

  private TetrominoHandler tetrominoHandler;

  @Mock
  private TetrominoFactory factory;

  @Before
  public void setUp() {
    this.tetrominoHandler = new TetrominoHandler(factory);
  }


}

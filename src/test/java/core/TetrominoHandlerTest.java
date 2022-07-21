package core;

import factory.TetrominoFactory;
import core.TetrominoHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TetrominoHandlerTest {

  private TetrominoHandler tetrominoHandler;

  @Mock
  private TetrominoFactory factory;

  @Before
  public void setUp() {
    this.tetrominoHandler = new TetrominoHandler(factory);
  }

  @Test
  public void test() {
    assertTrue(true);
  }

}

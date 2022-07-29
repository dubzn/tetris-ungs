import factory.ClassicTetrominoFactory;
import models.Tetromino;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClassicTetrominoFactoryTest {

  final int EXPECTED_OCCUPIED_SIZE = 4;

  ClassicTetrominoFactory factory = new ClassicTetrominoFactory();

  @Test
  public void givingTetrominoS_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino S = factory.createS();

    assertEquals(EXPECTED_OCCUPIED_SIZE, S.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, S.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, S.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, S.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoI_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino I = factory.createI();

    assertEquals(EXPECTED_OCCUPIED_SIZE, I.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, I.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, I.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, I.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoJ_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino J = factory.createJ();

    assertEquals(EXPECTED_OCCUPIED_SIZE, J.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, J.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, J.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, J.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoT_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino T = factory.createT();

    assertEquals(EXPECTED_OCCUPIED_SIZE, T.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, T.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, T.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, T.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoL_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino L = factory.createL();

    assertEquals(EXPECTED_OCCUPIED_SIZE, L.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, L.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, L.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, L.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoO_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino O = factory.createO();

    assertEquals(EXPECTED_OCCUPIED_SIZE, O.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, O.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, O.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, O.getInvertedVerticalForm().size());
  }

  @Test
  public void givingTetrominoZ_ThenForEveryPositionHasOnly4SquaresOccupied() {
    Tetromino Z = factory.createZ();

    assertEquals(EXPECTED_OCCUPIED_SIZE, Z.getHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, Z.getVerticalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, Z.getInvertedHorizontalForm().size());
    assertEquals(EXPECTED_OCCUPIED_SIZE, Z.getInvertedVerticalForm().size());
  }
}

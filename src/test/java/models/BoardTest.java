package models;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

  @Test
  public void givingANewBoard_WhenAskForSize_ThenShouldBe10x22() {
    Board board = new Board();
    assertEquals(new Integer(10), board.getWidth());
    assertEquals(new Integer(22), board.getHeight());
  }

  @Test
  public void givingANewBoard_WhenAskIfSomeSquareIsOccupied_ThenAllShouldBeNonOccupied() {
    Board board = new Board();
    assertTrue(board.getSquares().stream().noneMatch(Square::getOccupied));
  }
}

package service;

import models.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import util.DummyBoardFactory;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefaultScoreServiceTest {

  DefaultScoreService scoreService;

  @Before
  public void setUp() {
    this.scoreService = new DefaultScoreService();
  }

  @Test
  @DisplayName("Giving a new Game with 0 lines when call add method then Game score should be the same")
  public void givingNewGameWith0Lines_WhenCallAddMethod_ThenScoreShouldBeTheSame() {
    Game input = new Game(DummyBoardFactory.create());

    scoreService.add(input, 0);

    assertEquals((Integer) 0, input.getScore());
  }

  @Test
  @DisplayName("Giving a new Game with 1 lines when call add method then Game score should be 10")
  public void givingNewGameWith1Lines_WhenCallAddMethod_ThenScoreShouldBe10() {
    Game input = new Game(DummyBoardFactory.create());

    scoreService.add(input, 1);

    assertEquals((Integer) 10, input.getScore());
  }

  @Test
  @DisplayName("Giving a Game with 100 score with 5 lines when call add method then Game score should be 150")
  public void givingNewGameWith5Lines_WhenCallAddMethod_ThenScoreShouldBeTheSame() {
    Game input = new Game(DummyBoardFactory.create());
    input.setScore(100);

    scoreService.add(input, 5);

    assertEquals((Integer) 150, input.getScore());
  }

}

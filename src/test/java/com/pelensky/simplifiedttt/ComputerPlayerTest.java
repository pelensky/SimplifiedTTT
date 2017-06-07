package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
  private ComputerPlayer player1;
  private ComputerPlayer player2;
  private Board board;
  private Game game;

  @Before
  public void setUp() {
    player1 = new ComputerPlayer("X");
    player2 = new ComputerPlayer("O");
    board = new Board(3);
    game = new Game(board, player1, player2);
  }

  @Test
  public void markerIsStored() {
    assertEquals("X", player1.getMarker());
  }

  @Test
  public void computerPlaysInOnlyAvailableSpaceTie() {
    setUpBoard("1O2O3X4X5X6O7O8X");
    assertEquals(9, player2.chooseSpace(game));
  }

  @Test
  public void computerPlaysInOnlyAvailableSpaceWin() {
    setUpBoard("1O2O3X4X5O6O7X9X");
    assertEquals(8, player1.chooseSpace(game));
  }

  @Test
  public void computerOWinsGameIfItGetsTheOpportunity() {
    setUpBoard("1X5O708X9X");
    assertEquals(3, player2.chooseSpace(game));
  }

  @Test
  public void computerXWinsGameIfItGetsTheOpportunity() {
    setUpBoard("1X2X5O7O");
    assertEquals(3, player1.chooseSpace(game));
  }

  @Test
  public void computerXWinsGameIfItGetsTheOpportunity2() {
    setUpBoard("1O4X5X7O8O");
    assertEquals(6, player1.chooseSpace(game));
  }

  @Test
  public void computerOWinsGameIfItGetsTheOpportunity3() {
    setUpBoard("1X3O4O5O7X9X");
    assertEquals(8, player1.chooseSpace(game));
  }

  private void setUpBoard(String move) {
    for (int turn = 0; turn < move.length(); turn += 2) {
      Integer space = Character.getNumericValue(move.charAt(turn));
      String marker = String.valueOf(move.charAt(turn + 1));
      board.placeMarker(space, marker);
    }
  }
}

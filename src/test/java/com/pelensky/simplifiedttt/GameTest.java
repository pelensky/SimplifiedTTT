package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        board = new Board(3);
        player1 = new HumanPlayer("X");
        player2 = new HumanPlayer("O");
        game = new Game(board, player1, player2);
    }

    @Test
    public void player1StartsTheGame() {
        assertEquals("X", game.getCurrentPlayer().getMarker());
    }

    @Test
    public void playerCanTakeTurn() {
        game.takeTurn(1);
        assertEquals("X", game.showBoard().get(0));
    }

    @Test
    public void currentPlayerChangesAfterTurn() {
        game.takeTurn(1);
        assertEquals("O", game.getCurrentPlayer().getMarker());
    }




}

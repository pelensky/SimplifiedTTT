package com.pelensky.simplifiedttt;

import org.junit.Before;

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

}

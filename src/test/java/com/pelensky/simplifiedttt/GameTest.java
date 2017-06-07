package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;
    private Board board;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(new ByteArrayOutputStream());
        CLI cli = new CLI(in, out);board = new Board(3);
        player1 = new HumanPlayer(cli, "X");
        player2 = new HumanPlayer(cli, "O");
       game = new Game(board, player1, player2);
    }

    private void setSpacesAndCreateGame(List<String> strings) {
        board.spaces = new ArrayList<>(strings);
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

    @Test
    public void playerTwoCanTakeATurn() {
        game.takeTurn(1);
        game.takeTurn(2);
        assertEquals("O", game.showBoard().get(1));
    }

    @Test
    public void checkForWinHorizontalA() {
        setSpacesAndCreateGame(Arrays.asList("X", "X", "X", "4", "5", "6", "7", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalB() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "3", "O", "O", "O", "7", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinHorizontalC() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "3", "4", "5", "6", "X", "X", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalA() {
        setSpacesAndCreateGame(Arrays.asList("O", "2", "3", "O", "5", "6", "O", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalB() {
        setSpacesAndCreateGame(Arrays.asList("1", "X", "3", "4", "X", "6", "7", "X", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinVerticalC() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "O", "4", "5", "O", "7", "8", "O"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinLeftDiagonal() {
        setSpacesAndCreateGame(Arrays.asList("X", "2", "3", "4", "X", "6", "7", "8", "X"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkForWinRightDiagonal() {
        setSpacesAndCreateGame(Arrays.asList("1", "2", "O", "4", "O", "6", "O", "8", "9"));
        assertTrue(game.isGameOver());
    }

    @Test
    public void checkGameNotWon() {
        setSpacesAndCreateGame(Arrays.asList("X", "2", "3", "4", "O", "6", "O", "8", "9"));
        assertFalse(game.isGameOver());
    }

    @Test
    public void isGameTied() {
        setSpacesAndCreateGame(Arrays.asList("O", "X", "O", "X", "O", "X", "X", "O", "X"));
        assertTrue(game.isGameOver());
    }

}

package com.pelensky.simplifiedttt;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class CLITest {

    private ByteArrayOutputStream output;
    private String xWins = "3 1 1 1 9 2 8 3";
    private String tiedGame = " 3 1 1 1 5 4 7 3 2 8 9 6";

    public void setUp(String text){
        Scanner in = new Scanner(text);
        output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        CLI cli = new CLI(in, out);
        cli.run();
    }

    @Test
    public void welcome() {
        setUp(xWins);
        assertThat(output.toString(), containsString("Tic Tac Toe"));
    }

    @Test
    public void chooseBoardSize() {
        setUp(xWins);
        assertThat(output.toString(), containsString("Choose Board Size: 3 or 4"));
    }

    @Test
    public void choosePlayer1() {
        setUp(xWins);
        assertThat(output.toString(), containsString("Choose Player Type for Player 1:" + System.lineSeparator() + "1) Human" + System.lineSeparator() + "2) Computer"));
    }

    @Test
    public void choosePlayer2() {
        setUp(xWins);
        assertThat(output.toString(), containsString("Choose Player Type for Player 2:" + System.lineSeparator() + "1) Human" + System.lineSeparator() + "2) Computer"));
    }

    @Test
    public void printBoard() {
        setUp(xWins);
        assertThat(
                output.toString(),
                containsString("X take your turn" + System.lineSeparator() +
                        "  1 |  2 |  3" + System.lineSeparator() +
                        "--------------" + System.lineSeparator() +
                        "  4 |  5 |  6" + System.lineSeparator() +
                        "--------------" + System.lineSeparator() +
                        "  7 |  8 |  9" ));
    }

    @Test
    public void printWinner() {
        setUp(xWins);
        assertThat(output.toString(), containsString("X is the winner!"));
    }

    @Test
    public void printTie() {
        setUp(tiedGame);
        assertThat(output.toString(), containsString("The game was tied"));
    }




}

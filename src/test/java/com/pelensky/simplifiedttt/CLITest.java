package com.pelensky.simplifiedttt;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class CLITest {

    private ByteArrayOutputStream output;
    private CLI cli;

    public void setUp(String text){
        Scanner in = new Scanner(text);
        output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        cli = new CLI(in, out);
        cli.gameLoop();
    }

    @Test
    public void welcome() {
        setUp("3 1 2");
        assertThat(output.toString(), containsString("Tic Tac Toe"));
    }

    @Test
    public void chooseBoardSize() {
        setUp("3 1 2");
        assertThat(output.toString(), containsString("Choose Board Size: 3 or 4"));
    }

    @Test
    public void choosePlayer1() {
        setUp("3 1 1");
        assertThat(output.toString(), containsString("Choose Player Type for Player 1:" + System.lineSeparator() + "1) Human" + System.lineSeparator() + "2) Computer"));
    }

    @Test
    public void choosePlayer2() {
        setUp("3 1 1");
        assertThat(output.toString(), containsString("Choose Player Type for Player 2:" + System.lineSeparator() + "1) Human" + System.lineSeparator() + "2) Computer"));
    }



}

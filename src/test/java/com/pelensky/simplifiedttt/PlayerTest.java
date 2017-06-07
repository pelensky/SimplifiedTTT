package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player human;
    private Player computer;
    private CLI cli;

    @Before
    public void setUp() {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(new ByteArrayOutputStream());
        cli = new CLI(in, out);
        human = new HumanPlayer(cli, "X");
        computer = new ComputerPlayer("O");
    }

    @Test
    public void playerInitializedWithAMarker() {
        assertEquals("X", human.getMarker());
        assertEquals("O", computer.getMarker());
    }

}

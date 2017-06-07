package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

    public class HumanPlayerTest {
    private HumanPlayer human;

    public void setUp(String text) {
        Scanner in = new Scanner(text);
        PrintStream out = new PrintStream(new ByteArrayOutputStream());
        CLI cli = new CLI(in, out);
        human = new HumanPlayer(cli, "X");
    }

    @Test
    public void chooseSpace() {
        setUp("1");
        assertEquals(1, human.chooseSpace());
    }

}

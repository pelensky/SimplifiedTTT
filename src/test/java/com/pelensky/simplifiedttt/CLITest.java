package com.pelensky.simplifiedttt;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class CLITest {

    private CLI cli;

    public void setUp(String text){
        Scanner in = new Scanner(text);
        PrintStream out = new PrintStream(new ByteArrayOutputStream());
        cli = new CLI(in, out);
    }

    @Test
    public void getNumber() {
        setUp("1");
        assertEquals(1, cli.getNumber());
    }
}

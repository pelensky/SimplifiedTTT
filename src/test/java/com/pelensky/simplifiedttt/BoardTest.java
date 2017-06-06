package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private Board board;
    private Board bigBoard;

    @Before
    public void setUp() {
        board = new Board(3);
        bigBoard = new Board(4);
    }

    @Test
    public void boardInitializesWithNineOrSixteenSpaces() {
        assertEquals(9, board.getSpaces().size());
        assertEquals(16, bigBoard.getSpaces().size());
    }


}

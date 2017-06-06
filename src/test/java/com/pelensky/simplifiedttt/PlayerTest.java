package com.pelensky.simplifiedttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player human;

    @Before
    public void setUp() {
        human = new HumanPlayer("X");
    }

    @Test
    public void playerInitializedWithAMarker() {
        assertEquals("X", human.getMarker());
    }

}

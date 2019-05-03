package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.utils.PrinterImpl;
import com.alectronic.kata.gameoflife.utils.RandomGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

//    Testing step() & toString()

    @Test
    public void initBaseWorld() {
        World world = new World(new boolean[1][1]);

        String expectedWorld = "Step: 0\n" + " . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void initBaseWorld2() {
        World world = new World(new boolean[2][2]);

        String expectedWorld = "Step: 0\n" + " .  . \n" + " .  . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void initBaseWorld3WithLiveCell() {
        boolean[][] cells =  new boolean[][]{
                {true, false},
                {false, false},
        };

        World world = new World(cells);

        String expectedWorld = "Step: 0\n" + " *  . \n" + " .  . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void yAxis() {
        boolean[][] cells = new boolean[][]{
                {true, false, false},
                {true, false, false},
                {true, false, false}
        };

        World world = new World(cells);

        String expectedWorld = "Step: 0\n" + " *  .  . \n"  + " *  .  . \n" + " *  .  . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void xAxis() {
        boolean[][] cells = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };

        World world = new World(cells);

        String expectedWorld = "Step: 0\n" + " *  *  * \n" + " .  .  . \n" + " .  .  . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void middle() {
        boolean[][] cells = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };

        World world = new World(cells);

        String expectedWorld = "Step: 0\n" + " .  .  . \n" + " .  *  . \n" +  " .  .  . \n";
        String currentWorld = world.toString();

        assertEquals(expectedWorld,currentWorld);
    }

    @Test
    public void initRandomBaseWorld() {
        World world = new World();

        boolean[][] state = world.getState();

        assertEquals(20,state.length);
        assertEquals(20,state[0].length);
    }

    @Test
    public void initRandomBaseWorldAlwaysTrueGenerator() {
        World world = new World(1, 1, new PrinterImpl(), () -> true);

        boolean[][] state = world.getState();

        assertEquals(1,state.length);
        assertEquals(1,state[0].length);
        assertTrue(state[0][0]);
    }

    @Test
    public void initRandomBaseWorldAlwaysFalseGenerator() {
        World world = new World(1, 1, new PrinterImpl(), () -> false);

        boolean[][] state = world.getState();

        assertEquals(1,state.length);
        assertEquals(1,state[0].length);
        assertFalse(state[0][0]);
    }

}
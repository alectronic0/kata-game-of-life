package com.alectronic.kata.gameoflife;

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

}
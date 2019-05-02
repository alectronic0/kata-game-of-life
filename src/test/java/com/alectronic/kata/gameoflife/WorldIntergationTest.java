package com.alectronic.kata.gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorldIntergationTest {

    @Test
    public void shouldRemainDead() {
        boolean[][] cells = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);}

    @Test
    public void shouldDieOfUnderPopulation() {
        boolean[][] cells = new boolean[][]{
                {false, true, false},
                {true, false, false},
                {false, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);}

    @Test
    public void shouldCreateLife() {
        boolean[][] cells = new boolean[][]{
                {false, true, false},
                {true, true, false},
                {false, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {true, true, false},
                {true, true, false},
                {false, false, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);
    }

    @Test
    public void shouldCreateLifeButOnlyOneOtherLivesInProcess() {
        boolean[][] cells = new boolean[][]{
                {false, true, false},
                {true, false, true},
                {false, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {false, true, false},
                {false, true, false},
                {false, false, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);
    }

    @Test
    public void shouldCreateLifeButDieInProcess() {
        boolean[][] cells = new boolean[][]{
                {true, false, false},
                {false, false, true},
                {true, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);
    }


    @Test
    public void test() {
        boolean[][] cells = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {true, false, true},
                {true, false, true},
                {false, true, false}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);
    }

    @Test
    public void shouldKillOvercrowded() {
        boolean[][] cells = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        World world = new World(cells);
        world.print();
        world.step();
        world.print();
        boolean[][] currentWorld = world.getCells();

        boolean[][] expectedWorld = new boolean[][]{
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };

        assertArrayEquals("Expect:\n" + World.toString(expectedWorld),expectedWorld,currentWorld);
    }
}
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

    //    Testing Game of Life Rules;
    @Test
    public void anyLiveCellWithMoreThanThreeLiveNeighboursDiesAsIfByOvercrowding() {
        assertFalse(World.isCellAlive(4, true));
        assertFalse(World.isCellAlive(5, true));
        assertFalse(World.isCellAlive(6, true));
        assertFalse(World.isCellAlive(7, true));
        assertFalse(World.isCellAlive(8, true));
    }

    @Test
    public void anyLiveCellWithTwoOrThreeLiveNeighboursLivesOnToTheNextGeneration() {
        assertTrue(World.isCellAlive(2, true));
        assertTrue(World.isCellAlive(3, true));
    }

    @Test
    public void anyDeadCellWithExactlyThreeLiveNeighboursBecomesALiveCell() {
        assertTrue(World.isCellAlive(3, false));
    }

    @Test
    public void AnyLiveCellWithFewerThanTwoLiveNeighboursDiesAsIfCausedByUnderpopulation() {
        assertFalse(World.isCellAlive(0,true));
        assertFalse(World.isCellAlive(1,true));
    }

    @Test
    public void noMatchingState() {
        assertFalse(World.isCellAlive(0,false));
        assertFalse(World.isCellAlive(1,false));
        assertFalse(World.isCellAlive(2,false));
        assertFalse(World.isCellAlive(4,false));
        assertFalse(World.isCellAlive(5,false));
        assertFalse(World.isCellAlive(6,false));
        assertFalse(World.isCellAlive(7,false));
        assertFalse(World.isCellAlive(8,false));
    }

//    Counting Neighbours Check
//    * * .
//    * * .
//    . . *


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Counting Neighbours (0,0)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void shouldCountNoAgentsShouldZeroNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountZeroNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountOneNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountOneNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Counting Neighbours (0,1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void shouldCountNoAgentsShouldZeroNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountOneNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountTwoNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountFourNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Counting Neighbours (1,0)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void shouldCountNoAgentsShouldZeroNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountThreeNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountThreeNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountFourNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountFiveNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountFiveNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,0,world);
        assertEquals(5,numberOfNeighbours);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Counting Neighbours (1,1)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void shouldCountNoAgentsShouldZeroNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountTwoNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountThreeNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountFourNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountFourNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountFiveNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountSixNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(6,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountSevenNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(7,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountEightNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(1,1,world);
        assertEquals(8,numberOfNeighbours);
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Counting Neighbours (2,2)
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void shouldCountNoAgentsShouldZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountOneNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountTwoNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountTwoNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountThreeNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountThreeNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = World.countNumberOfLiveNeighbour(2,2,world);
        assertEquals(3,numberOfNeighbours);
    }

}
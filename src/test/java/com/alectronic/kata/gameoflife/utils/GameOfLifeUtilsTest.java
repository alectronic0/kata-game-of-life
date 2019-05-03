package com.alectronic.kata.gameoflife.utils;

import org.junit.Test;

import static com.alectronic.kata.gameoflife.utils.GameOfLifeUtils.*;
import static org.junit.Assert.*;

public class GameOfLifeUtilsTest {
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
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountZeroNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountOneNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountOneNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountThreeNeighboursFromX0Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,0,world);
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
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountOneNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountTwoNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountFourNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountFiveNeighboursFromX0Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(0,1,world);
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
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountTwoNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountThreeNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountThreeNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountFourNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountFiveNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountFiveNeighboursFromX1Y0() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,0,world);
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
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountOneNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountTwoNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountThreeNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountFourNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountFourNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(4,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountFiveNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(5,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountSixNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(6,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountSevenNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
        assertEquals(7,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountEightNeighboursFromX1Y1() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(1,1,world);
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
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasOneAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasTwoAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, false},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasThreeAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {false, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasFourAgentsShouldCountZeroNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, false, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(0,numberOfNeighbours);
    }

    @Test
    public void worldHasFiveAgentsShouldCountOneNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, false},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(1,numberOfNeighbours);
    }

    @Test
    public void worldHasSixAgentsShouldCountTwoNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {false, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasSevenAgentsShouldCountTwoNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, false, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(2,numberOfNeighbours);
    }

    @Test
    public void worldHasEightShouldCountThreeNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, false}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(3,numberOfNeighbours);
    }

    @Test
    public void worldHasNineAgentsShouldCountThreeNeighboursFromX2Y2() {
        boolean[][] world = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int numberOfNeighbours = countNumberOfLiveNeighbour(2,2,world);
        assertEquals(3,numberOfNeighbours);
    }
}
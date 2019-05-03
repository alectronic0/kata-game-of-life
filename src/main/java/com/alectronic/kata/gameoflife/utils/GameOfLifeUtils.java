package com.alectronic.kata.gameoflife.utils;

public class GameOfLifeUtils {

    public static int countNumberOfLiveNeighbour(final int x, final int y, final boolean[][] cells) {
        int count = 0;
        for (int xOffSet = x-1; xOffSet <= x+1; xOffSet++) {
            for (int yOffSet = y-1; yOffSet <= y+1; yOffSet++) {
                if (
                        !(xOffSet == x && yOffSet == y)
                                && 0 <= xOffSet && xOffSet < cells.length
                                && 0 <= yOffSet && yOffSet < cells[xOffSet].length
                                && cells[xOffSet][yOffSet]
                ) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isCellAlive(final int numberOfLiveNeighbour, final boolean isCurrentCellAlive) {
        return (
                isCurrentCellAlive
                        && 1 < numberOfLiveNeighbour
                        && numberOfLiveNeighbour < 4
        ) || (
                !isCurrentCellAlive
                        && numberOfLiveNeighbour == 3
        );
    }


    public static boolean[][] deepCopy(boolean[][] cells) {
        boolean[][] newWorld = new boolean[cells.length][cells[0].length] ;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                newWorld[x][y] = cells[x][y];
            }
        }
        return newWorld;
    }

    public static String toString(boolean[][] cells) {
        StringBuilder s = new StringBuilder();
        for (boolean[] cell : cells) {
            for (boolean b : cell) {
                s.append(b ? " * " : " . ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static boolean[][] convertStringToWorld(String)

}

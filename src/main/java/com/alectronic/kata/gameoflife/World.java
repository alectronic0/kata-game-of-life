package com.alectronic.kata.gameoflife;

public class World {

    private int step = 0;

    private final boolean[][] cells;

    World() {
        this(20,20);
    }

    World(boolean[][] cells) {
        this.cells = cells;
    }

    World(int xLength, int yLength) {
        this.cells = new boolean[xLength][yLength];
        randomInit();
    }

    public boolean[][] getCells() {
        return cells;
    }

    private void randomInit() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = Math.random() < 0.2;
            }
        }
    }

    private void updateWorld(final boolean[][] newWorld) {
        for (int x = 0; x < newWorld.length; x++) {
            for (int y = 0; y < newWorld[x].length; y++) {
                cells[x][y] = newWorld[x][y];
            }
        }
        step++;
    }

    public void step() {
        boolean[][] newWorld = deepCopy();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                boolean isCurrentCellAlive = cells[x][y];
                int numberOfLiveNeighbour = countNumberOfLiveNeighbour(x,y,cells);
                newWorld[x][y] = isCellAlive(numberOfLiveNeighbour,isCurrentCellAlive);
            }
        }
        updateWorld(newWorld);
    }

    private boolean[][] deepCopy() {
        boolean[][] newWorld = new boolean[cells.length][cells[0].length] ;
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                newWorld[x][y] = cells[x][y];
            }
        }
        return newWorld;
    }

    static int countNumberOfLiveNeighbour(final int x, final int y, final boolean[][] cells) {
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

    static boolean isCellAlive(final int numberOfLiveNeighbour, final boolean isCurrentCellAlive) {
        return (
                isCurrentCellAlive
                        && 1 < numberOfLiveNeighbour
                        && numberOfLiveNeighbour < 4
        ) || (
                !isCurrentCellAlive
                        && numberOfLiveNeighbour == 3
        );
    }

    public void print() {
        System.out.println("Step: " + step);
        System.out.println(this.toString());
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

    public String toString() {
        return toString(cells);
    }

}

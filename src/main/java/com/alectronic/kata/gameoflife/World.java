package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import com.alectronic.kata.gameoflife.utils.GameOfLifeUtils;

import java.util.Arrays;

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

    public void step() throws DeadWorldException {
        boolean[][] newWorld = GameOfLifeUtils.deepCopy(cells);
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                boolean isCurrentCellAlive = cells[x][y];
                int numberOfLiveNeighbour = GameOfLifeUtils.countNumberOfLiveNeighbour(x,y,cells);
                newWorld[x][y] = GameOfLifeUtils.isCellAlive(numberOfLiveNeighbour,isCurrentCellAlive);
            }
        }
        if (Arrays.deepEquals(cells, newWorld)) {throw new DeadWorldException();}
        updateWorld(newWorld);
    }

    public void print() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(this.toString());
    }

    public String toString() {
        return "Step: " + step + "\n" + GameOfLifeUtils.toString(cells);
    }

}

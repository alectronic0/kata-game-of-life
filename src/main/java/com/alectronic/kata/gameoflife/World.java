package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import com.alectronic.kata.gameoflife.utils.GameOfLifeUtils;
import com.alectronic.kata.gameoflife.utils.Printer;
import com.alectronic.kata.gameoflife.utils.PrinterImpl;

import java.util.Arrays;

public class World {

    private int step = 0;
    private final boolean[][] world;
    private Printer printer;

    World(boolean[][] world) {
        this.world = world;
        this.printer = new PrinterImpl();
    }

    World() {
        this(20,20);
    }

    World(int xLength, int yLength) {
        this(xLength,yLength, new PrinterImpl());
    }

    World(int xLength, int yLength, Printer printer) {
        this.world = new boolean[xLength][yLength];
        this.printer = printer;
        randomInit();
    }

    public boolean[][] getState() {
        return world;
    }

    private void randomInit() {
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                world[x][y] = Math.random() < 0.2;
            }
        }
    }

    private void updateWorld(final boolean[][] newWorld) {
        for (int x = 0; x < newWorld.length; x++) {
            for (int y = 0; y < newWorld[x].length; y++) {
                world[x][y] = newWorld[x][y];
            }
        }
        step++;
    }

    public void step() throws DeadWorldException {
        boolean[][] newWorld = GameOfLifeUtils.deepCopy(world);
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                boolean isCurrentCellAlive = world[x][y];
                int numberOfLiveNeighbour = GameOfLifeUtils.countNumberOfLiveNeighbour(x,y, world);
                newWorld[x][y] = GameOfLifeUtils.isCellAlive(numberOfLiveNeighbour,isCurrentCellAlive);
            }
        }
        if (Arrays.deepEquals(world, newWorld)) {throw new DeadWorldException();}
        updateWorld(newWorld);
    }

    public void print() {
        printer.print(this);
    }

    public String toString() {
        return "Step: " + step + "\n" + GameOfLifeUtils.toString(world);
    }

}

package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import com.alectronic.kata.gameoflife.exception.MalformedLine;
import com.alectronic.kata.gameoflife.utils.GameOfLifeUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.alectronic.kata.gameoflife.utils.GameOfLifeUtils.getStateFromFile;

public class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static void main(String... args) throws InterruptedException, DeadWorldException, IOException, MalformedLine {
        World app;
        if (0 >= args.length) {
            app = new World(10,60);
        } else {
            app = new World(getStateFromFile(args[0]));
        }

        try {
            while (true) {
                System.out.println(app.toString());
                TimeUnit.MILLISECONDS.sleep(100);
                app.step();
            }
        } catch (DeadWorldException e) {
            LOGGER.severe("The world has died");
            throw e;
        }
    }

}

package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import com.alectronic.kata.gameoflife.exception.MalformedLine;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.alectronic.kata.gameoflife.utils.GameOfLifeUtils.getStateFromFile;

class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static void main(String... args) throws InterruptedException, DeadWorldException, IOException, MalformedLine {
        World app;
        if (0 >= args.length) {
            app = new World(10,30);
        } else {
            try {
                app = new World(getStateFromFile(args[0]));
            } catch (IOException e) {
                LOGGER.severe("Something went wrong reading the file please check " + e.getMessage());
                throw e;
            } catch (MalformedLine e) {
                LOGGER.severe("Your file was Malformed please check " + e.getMessage());
                throw e;
            }
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

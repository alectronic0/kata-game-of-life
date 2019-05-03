package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;

import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static void main(String... args) throws InterruptedException, DeadWorldException {
        World app;
        if (0 >= args.length) {
            app = new World(10,60);
        } else {

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

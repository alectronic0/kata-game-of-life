package com.alectronic.kata.gameoflife;

import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String... args) throws InterruptedException {
        World app = new World();

        while (true) {
            System.out.println(app.toString());
            TimeUnit.MILLISECONDS.sleep(500);
            app.step();
        }
    }

}

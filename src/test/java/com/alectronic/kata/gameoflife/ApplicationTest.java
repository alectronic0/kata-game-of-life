package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import org.junit.Test;

public class ApplicationTest {

    @Test(expected = DeadWorldException.class)
    public void breakOutAfterItStagnates() throws InterruptedException, DeadWorldException {
        Application.main("test1.txt");
    }

}
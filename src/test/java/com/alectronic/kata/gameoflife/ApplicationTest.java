package com.alectronic.kata.gameoflife;

import com.alectronic.kata.gameoflife.exception.DeadWorldException;
import com.alectronic.kata.gameoflife.exception.MalformedLine;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

public class ApplicationTest {

    @Test(expected = DeadWorldException.class)
    public void breakOutAfterItStagnates1() throws InterruptedException, DeadWorldException, IOException, MalformedLine {
        Application.main(getResouceFilePath("test1.txt"));
    }

    @Test(expected = IOException.class)
    public void breakOutAfterItStagnates2() throws InterruptedException, DeadWorldException, IOException, MalformedLine {
        Application.main("test2.txt");
    }

    private String getResouceFilePath(String fileName) {
        return Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).getFile();
    }

}
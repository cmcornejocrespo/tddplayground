package com.java.tdd.playground.filenio.strategy.java7;

import com.java.tdd.playground.filenio.reader.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.System.setOut;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Carlos.Cornejo on 05/07/2015.
 */
public class RecursiveNumberOfFilesReadingTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private FileReader sut;

    @Before
    public void setUpStreams() {

        setOut(new PrintStream(outContent));
        sut = new FileReader(new RecursiveNumberOfFilesReading());
    }

    @After
    public void cleanUpStreams() {

        setOut(null);
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenRecursiveReadingStrategyUsed() throws IOException {

        sut.getSolution("C:\\temp\\carlos");

        assertThat(outContent.toString()).isEqualTo("Total number of files 2");
    }

    @Test(expected = IOException.class)
    public void shouldReturnIOExceptionWhenNonExistingPath() throws IOException {

        sut.getSolution("I Don't exist");

        fail("it shouldn't reach here");
    }

}
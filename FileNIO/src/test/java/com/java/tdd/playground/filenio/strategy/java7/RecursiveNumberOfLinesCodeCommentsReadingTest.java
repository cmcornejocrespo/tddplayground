package com.java.tdd.playground.filenio.strategy.java7;

import com.java.tdd.playground.filenio.reader.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;

import static java.lang.System.setOut;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by Carlos.Cornejo on 05/07/2015.
 */
public class RecursiveNumberOfLinesCodeCommentsReadingTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private FileReader sut;

    @Before
    public void setUpStreams() {

        setOut(new PrintStream(outContent));
        sut = new FileReader(new RecursiveNumberOfLinesCodeCommentsReading());
    }

    @After
    public void cleanUpStreams() {

        setOut(null);
    }

    @Test
    public void shouldReturnExpectedOutcomeWhenRecursiveNumberOfLinesCodeCommentsStrategyUsed() throws IOException, URISyntaxException {

        //test fixtures
        FileReader sut = new FileReader(new RecursiveNumberOfLinesCodeCommentsReading());

        sut.getSolution("C:\\temp\\carlos2");

        assertThat(outContent.toString()).isEqualTo("File New Text Document.txt, line 1, contains comments\n" +
                "File New Text Document.txt, line 2, contains comments\n" +
                "File New Text Document.txt, line 3, contains code\n");
    }

    @Test(expected = IOException.class)
    public void shouldReturnIOExceptionWhenNonExistingPath() throws IOException, URISyntaxException {

        sut.getSolution("I Don't exist");

        fail("it shouldn't reach here");
    }
}
package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static java.lang.System.setOut;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfLinesTest {

    final OutputStream output = new ByteArrayOutputStream();

    FileReadingStrategy sut = new RecursiveJava8NumberOfLines();

    @Before
    public void setOutput() {

        setOut(new PrintStream(output));
    }

    @Test
    public void shouldReturnExpectedNumberOfLines() {

        sut.getResult("C:\\temp\\carlos");

        assertThat(output.toString()).isEqualTo("Total number of lines: 0 of file: New Text Document (2).txt\n" +
                "Total number of lines: 0 of file: New Text Document.txt\n");
    }
}

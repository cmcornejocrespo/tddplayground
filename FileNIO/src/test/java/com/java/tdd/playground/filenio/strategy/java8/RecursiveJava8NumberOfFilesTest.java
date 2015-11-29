package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfFilesTest {

    final OutputStream output = new ByteArrayOutputStream();

    FileReadingStrategy sut = new RecursiveJava8NumberOfFiles();

    @Before
    public void setOutput() {

        System.setOut(new PrintStream(output));
    }

    @Test
    public void shouldReturnExpectedNumberOfFiles() throws IOException {

        sut.getResult("C:\\temp\\carlos");

        assertThat(output.toString()).isEqualTo("Number of Files: 2");
    }
}

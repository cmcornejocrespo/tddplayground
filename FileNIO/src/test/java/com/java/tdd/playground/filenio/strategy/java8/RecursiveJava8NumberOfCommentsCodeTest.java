package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static java.lang.System.setOut;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfCommentsCodeTest {

    final OutputStream output = new ByteArrayOutputStream();

    FileReadingStrategy sut = new RecursiveJava8NumberOfCommentsAndCode();

    @Before
    public void setOutput() {

        setOut(new PrintStream(output));
    }

    @Test
    public void shouldReturnExpectedNumberOfCommentsAndCode() throws IOException {

        sut.getResult("file");

        assertThat(output.toString()).isEqualTo("File C:\\temp\\carlos2\\New Text Document.txt, line 1, contains comments\n" +
                "File C:\\temp\\carlos2\\New Text Document.txt, line 1, contains comments\n" +
                "File C:\\temp\\carlos2\\New Text Document.txt, line 1, contains code\n");
    }
}

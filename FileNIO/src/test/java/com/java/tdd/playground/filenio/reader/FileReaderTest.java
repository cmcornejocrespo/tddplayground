package com.java.tdd.playground.filenio.reader;


import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static java.nio.file.Paths.get;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class FileReaderTest {

    @Mock
    FileReadingStrategy strategy;

    private FileReader sut;

    @Before
    public void setup() {
        sut = new FileReader(strategy);
    }

    @Test
    public void shouldReturnCallExpectedStrategy() throws IOException {

        //test fixtures
        final String path = "ANY PATH";

        sut.getSolution(path);

        verify(strategy).getResult(path);
    }

    @Test(expected = IOException.class)
    public void shouldPropagateExceptionWhenStrategyThrowsException() throws IOException {

        //test fixtures
        final String path = "ANY PATH";

        willThrow(new IOException()).given(strategy).getResult(anyString());

        //when
        sut.getSolution(path);

        fail("it shouldn't reach here");
    }

}

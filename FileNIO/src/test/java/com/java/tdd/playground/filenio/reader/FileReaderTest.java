package com.java.tdd.playground.filenio.reader;


import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.anyString;
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
    public void shouldReturnCallExpectedStrategy() {

        //test fixtures
        final String path = "ANY PATH";

        sut.getSolution(path);

        verify(strategy).getResult(path);
    }

    @Test(expected = IOException.class)
    public void shouldPropagateExceptionWhenStrategyThrowsException() {

        //test fixtures
        final String path = "ANY PATH";

        willThrow(new IOException()).given(strategy).getResult(anyString());

        //when
        sut.getSolution(path);

        fail("it shouldn't reach here");
    }

}

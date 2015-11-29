package com.java.tdd.playground.filenio.strategy;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public interface FileReadingStrategy {

    void getResult(String path) throws IOException;

}

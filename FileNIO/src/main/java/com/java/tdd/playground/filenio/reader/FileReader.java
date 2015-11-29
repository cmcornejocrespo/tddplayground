package com.java.tdd.playground.filenio.reader;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.IOException;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public class FileReader {

    final FileReadingStrategy strategy;

    public FileReader(FileReadingStrategy strategy) {
        this.strategy = strategy;
    }

    public void getSolution(String path) throws IOException {

        strategy.getResult(path);
    }
}

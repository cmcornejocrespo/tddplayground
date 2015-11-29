package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.IOException;
import java.nio.file.Paths;

import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.walk;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfFiles implements FileReadingStrategy {

    public void getResult(String path) throws IOException {

        final long count = walk(Paths.get(path))
                .filter(path1 -> isRegularFile(path1))
                .count();

        System.out.printf("Number of Files: %d", count);

    }
}

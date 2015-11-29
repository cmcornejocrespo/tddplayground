package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.IOException;

import static java.lang.System.out;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.walk;
import static java.nio.file.Paths.get;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfLines implements FileReadingStrategy {

    @Override
    public void getResult(String path) throws IOException {


        walk(get(path))
                .filter(file -> isRegularFile(file))
                .forEach(path1 -> {
                    try {
                        final long count = lines(path1).count();
                        out.printf("Total number of lines: %d of file: %s\n",
                                count, path1.getFileName().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}

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
    public void getResult(String absolutePath) {


        try {
            walk(get(absolutePath))
                    .filter(file -> isRegularFile(file))
                    .forEach(filePath -> {
                        try {

                            final long count = lines(filePath).count();

                            out.printf("Total number of lines: %d of file: %s\n", count, filePath.getFileName().toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

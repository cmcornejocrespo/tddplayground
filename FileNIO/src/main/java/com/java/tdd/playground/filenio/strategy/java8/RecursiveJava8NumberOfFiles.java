package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.IOException;

import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.walk;
import static java.nio.file.Paths.get;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfFiles implements FileReadingStrategy {

    public void getResult(String absolutePath) {

        long count = 0;
        try {
            count = walk(get(absolutePath))
                    .filter(path -> isRegularFile(path))
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Number of Files: %d", count);

    }
}

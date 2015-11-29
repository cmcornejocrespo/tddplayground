package com.java.tdd.playground.filenio.strategy.java8;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.walk;
import static java.nio.file.Paths.get;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class RecursiveJava8NumberOfCommentsAndCode implements FileReadingStrategy {

    @Override
    public void getResult(String path) throws IOException {


        walk(get(path))
                .filter(file -> isRegularFile(file))
                .forEach(filePath -> {
                    try {
                        final Stream<String> lines = lines(filePath);
                        int numOfLine = 1;
                        lines.forEach(p -> process(p, numOfLine, filePath));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void process(String line, int numOfLine, Path path1) {

        if (line.startsWith("//") || line.startsWith("/*")) {

            out.printf("File %s, line %d, contains comments\n", path1, numOfLine);
        } else {

            out.printf("File %s, line %d, contains code\n", path1, numOfLine);
        }
    }


}

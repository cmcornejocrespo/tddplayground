package com.java.tdd.playground.filenio.strategy.java7;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public class RecursiveNumberOfLinesCodeCommentsReading implements FileReadingStrategy {

    @Override
    public void getResult(String path) throws IOException {

        final Path resolvedPath = get(path);

        if (!Files.exists(resolvedPath)) {
            throw new IOException("Path not exists:" + resolvedPath);
        }

        getFilesRecursive(resolvedPath);

    }

    private void getFilesRecursive(Path resolvedPath) throws IOException {

        if (isRegularFile(resolvedPath)) {

            doCommentsAndCodeParsingPrinting(resolvedPath);

        } else {

            final String[] listOfFiles = new File(resolvedPath.toString()).list();

            for (int i = 0; i < listOfFiles.length; i++) {

                File resource = new File(listOfFiles[i].toString());

                getFilesRecursive(get(resolvedPath + "\\" + resource.getPath()));
            }
        }

    }

    private void doCommentsAndCodeParsingPrinting(Path resolvedPath) throws IOException {

        Path file;
        file = Paths.get(resolvedPath.toString());

        int lineNumber = 1;
        for (String line : readAllLines(file)) {
            if (line.startsWith("//") || line.startsWith("/*")) {

                System.out.printf("File %s, line %d, contains comments\n", file.getFileName(), lineNumber);
            } else {

                System.out.printf("File %s, line %d, contains code\n", file.getFileName(), lineNumber);
            }
            lineNumber++;
        }
    }
}

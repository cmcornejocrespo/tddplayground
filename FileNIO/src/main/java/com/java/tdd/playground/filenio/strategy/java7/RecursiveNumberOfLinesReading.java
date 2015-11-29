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
public class RecursiveNumberOfLinesReading implements FileReadingStrategy {

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

            Path file;
            file = Paths.get(resolvedPath.toString());
            System.out.printf("File %s contains %d lines\n", file.getFileName(), readAllLines(file).size());

        } else {

            final String[] listOfFiles = new File(resolvedPath.toString()).list();

            for (int i = 0; i < listOfFiles.length; i++) {

                File resource = new File(listOfFiles[i].toString());

                getFilesRecursive(get(resolvedPath + "\\" + resource.getPath()));
            }
        }

    }
}

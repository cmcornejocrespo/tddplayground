package com.java.tdd.playground.filenio.strategy.java7;

import com.java.tdd.playground.filenio.strategy.FileReadingStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Paths.get;

/**
 * Created by Carlos.Cornejo on 04/07/2015.
 */
public class RecursiveNumberOfFilesReading implements FileReadingStrategy {

    @Override
    public void getResult(String path) throws IOException {

        final Path resolvedPath = Paths.get(path);

        if (!exists(resolvedPath)) {
            throw new IOException("Path not exists:" + resolvedPath);
        }

        int total = getFilesRecursive(resolvedPath);

        System.out.printf("Total number of files %d", total);

    }

    private int getFilesRecursive(Path resolvedPath) {

        int totalNumberOfFile = 0;

        if (isRegularFile(resolvedPath)) {
            totalNumberOfFile++;
        } else {

            final String[] listOfFiles = new File(resolvedPath.toString()).list();

            for (int i = 0; i < listOfFiles.length; i++) {

                File resource = new File(listOfFiles[i].toString());

                totalNumberOfFile += getFilesRecursive(get(resolvedPath + "\\" + resource.getPath()));
            }
        }

        return totalNumberOfFile;
    }
}

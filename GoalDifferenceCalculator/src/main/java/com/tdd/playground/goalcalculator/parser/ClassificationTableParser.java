package com.tdd.playground.goalcalculator.parser;

import com.tdd.playground.goalcalculator.domain.Team;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

//for simplicity we don't implement interfaces
public class ClassificationTableParser {

    private static final String
            TEAM_COLUMN_PREFIX = "Team",
            DASH_COLUMN_PREFIX = "-",
            WHITE_SPACES_REGEX = "\\s+";

    private final File file;

    public ClassificationTableParser(final String fileName) {

        final ClassLoader classLoader = getClass().getClassLoader();

        file = new File(classLoader.getResource(fileName).getFile());
    }

    public List<Team> getListOfParsedTeams() {

        List<String> classificationRows = new ArrayList<>();
        List<Team> listOfTeams = new ArrayList<>();
        try {

            classificationRows = readAllLines(get(file.getAbsolutePath()));

        } catch (IOException e) {
            //we're assuming that file content exists and it's well-formed
            //do nothing
            e.printStackTrace();
        }

        for (String classificationRow : classificationRows) {

            if (!classificationRow.startsWith(TEAM_COLUMN_PREFIX) && !classificationRow.startsWith(DASH_COLUMN_PREFIX)) {

                Team team = parseClassificationRow(classificationRow);
                listOfTeams.add(team);
            }
        }

        return listOfTeams;
    }

    private Team parseClassificationRow(String classificationRow) {

        final String[] splitClassificationRow = classificationRow.split(WHITE_SPACES_REGEX);

        //we assume a well-formed table data rows with expected positions for columns
        final String teamName = splitClassificationRow[1];
        final int goalsScored = parseInt(splitClassificationRow[6]);
        final int goalsAgainst = parseInt(splitClassificationRow[8]);

        return new Team(teamName, goalsScored, goalsAgainst);
    }
}
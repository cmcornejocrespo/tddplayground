package com.tdd.playground.goalcalculator.domain;

import java.util.Comparator;
import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.hash;

public class Team {

    private final String teamName;
    private final int goalsScored;
    private final int goalsAgainst;

    public Team(String teamName, int goalsScored, int goalsAgainst) {

        this.teamName = teamName;
        this.goalsScored = goalsScored;
        this.goalsAgainst = goalsAgainst;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    @Override
    public String toString() {

        final int goalsDifference = goalsScored - goalsAgainst;
        final String message = "%s, with a goal difference of %s (F:%s - A:%s)";

        return format(message, teamName, goalsDifference, goalsScored, goalsAgainst).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return goalsScored == team.goalsScored &&
                goalsAgainst == team.goalsAgainst &&
                Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return hash(teamName, goalsScored, goalsAgainst);
    }

    public static class GoalDifferenceComparator implements Comparator<Team> {

        public int compare(Team team1, Team team2) {

            final int team1GoalDifference = team1.getGoalsScored() - team1.getGoalsAgainst();
            final int team2GoalDifference = team2.getGoalsScored() - team2.getGoalsAgainst();

            if (team1GoalDifference - team2GoalDifference < 0) {
                return 1;
            } else if (team1GoalDifference - team2GoalDifference > 0) {
                return -1;
            }

            return 0;
        }
    }
}

package com.tdd.playground.goalcalculator;

import com.tdd.playground.goalcalculator.parser.ClassificationTableParser;

/**
 * Author Carlos Cornejo. 06/12/15
 * carlos.cornejo.crespo@gmail.com
 */
public class GoalDifferenceCalculatorMain {

    public static void main(String[] args) {

        final GoalDifferenceCalculator goalDifferenceCalculator =
                new GoalDifferenceCalculator(new ClassificationTableParser("table_results"));

        goalDifferenceCalculator.getTeamWithSmallestGoalDifference();
    }
}

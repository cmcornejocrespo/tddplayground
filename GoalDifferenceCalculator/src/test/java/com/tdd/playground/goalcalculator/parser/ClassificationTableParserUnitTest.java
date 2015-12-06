package com.tdd.playground.goalcalculator.parser;

import com.tdd.playground.goalcalculator.domain.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassificationTableParserUnitTest {

    private ClassificationTableParser sut;

    @Before
    public void setup() {
        sut = new ClassificationTableParser("table_results_well_formed");
    }

    @Test
    public void itShouldReturnTheExpectedListOfTeams() {

        //when
        final List<Team> outcome = sut.getListOfParsedTeams();

        //then
        assertThat(outcome).containsExactly(
                new Team("Arsenal", 79, 36),
                new Team("Liverpool", 67, 30),
                new Team("Manchester_U", 87, 45),
                new Team("Newcastle", 74, 52),
                new Team("Leeds", 53, 37),
                new Team("Chelsea", 66, 38),
                new Team("West_Ham", 48, 57),
                new Team("Aston_Villa", 46, 47));
    }
}

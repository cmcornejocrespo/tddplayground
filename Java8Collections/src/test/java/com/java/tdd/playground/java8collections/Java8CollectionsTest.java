package com.tdd.playground.java8collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Carlos.Cornejo on 06/07/2015.
 */
public class Java8CollectionsTest {

    private static final List<Employee> LIST_OF_EMPLOYEES = new ArrayList<Employee>() {{
        add(new Employee("name1", "twitterAcount1", 7));
        add(new Employee("name2", "twitterAcount2", 5));
    }};

    @Test
    public void shouldReturnExpectedCountOfItems() {

        final long outcome = LIST_OF_EMPLOYEES.stream()
                .filter(employee -> employee.name.equals("name1"))
                .count();

        assertThat(outcome).isEqualTo(1);
    }

    @Test
    public void shouldReturnExpectedSumOfExperience() {

        final int sumOfYearsOfExperience = LIST_OF_EMPLOYEES.stream()
                .mapToInt(Employee::getYearsExperience)
                .sum();

        assertThat(sumOfYearsOfExperience).isEqualTo(12);
    }

    public static class Employee {

        final String name;
        final String twitterAccount;
        final int yearsExperience;

        public int getYearsExperience() {
            return yearsExperience;
        }

        public Employee(String name, String twitterAccount, int yearsExperience) {
            this.name = name;
            this.twitterAccount = twitterAccount;
            this.yearsExperience = yearsExperience;
        }
    }
}

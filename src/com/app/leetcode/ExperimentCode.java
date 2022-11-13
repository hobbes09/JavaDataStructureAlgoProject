package com.app.leetcode;

import com.app.Solution;

import java.util.stream.Stream;

public class ExperimentCode implements Solution {

    static class Employee {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }

    @Override
    public void execute() {

        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        Stream<Employee> employeeStream = Stream.of(arrayOfEmps);

    }
}

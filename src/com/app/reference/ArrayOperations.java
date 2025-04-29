package com.app.reference;

import com.app.Solution;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayOperations implements Solution {
    @Override
    public void execute() {


        String str = "eat";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(new String(arr));

        // =====================================================

        int[][] seats = {{3,2},{1,3},{1,2},{2,6},{3,1},{3,10}};
        Arrays.sort(seats, (s1, s2)-> {
            return s1[0]!=s2[0]? s1[0]-s2[0]:s1[1]-s2[1];
        });

        Iterator<int[]> it = Arrays.stream(seats).iterator();
        while (it.hasNext()) {
            System.out.println(Arrays.toString(it.next()));
        }

        // =====================================================

        String num = "23";
        int numInt = Integer.parseInt(num);
        System.out.println(numInt);

        // =====================================================

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers); // Output: [2, 4]

        // =====================================================

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> squares = numbers1.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares); // Output: [1, 4, 9]

        // =====================================================

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);

        // =====================================================

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 40)
        );

        AgeSummaryStatistics result = people.stream()
                .map(person -> new AgeSummaryStatistics(person.getAge(), 1))
                .reduce(new AgeSummaryStatistics(0, 0), AgeSummaryStatistics::combine);

        double averageAge = (result.getCount() == 0) ? 0 : (double) result.getSum() / result.getCount();
        System.out.println("Average Age: " + averageAge);

    }

    class Person {
        private String name;
        private int age;

        // Constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter
        public int getAge() {
            return age;
        }
    }

    public class AgeSummaryStatistics {
        private final int sum;
        private final int count;

        // Constructor
        public AgeSummaryStatistics(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }

        // Combines two AgeSummaryStatistics instances
        AgeSummaryStatistics combine(AgeSummaryStatistics other) {
            return new AgeSummaryStatistics(this.sum + other.sum, this.count + other.count);
        }

        // Getter methods
        public int getSum() {
            return sum;
        }

        public int getCount() {
            return count;
        }
    }

}

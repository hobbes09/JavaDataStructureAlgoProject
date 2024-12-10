package com.app.reference;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreaming implements Solution {
    @Override
    public void execute() {

        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        // Any match
        boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
        System.out.println(isExist);

        // Filter
        Stream<String> stream = list.stream().filter(element -> element.contains("d"));
        System.out.println(stream.collect(Collectors.toList()));

        // Mapping
        Stream<String> capitalisedStream = list.stream().map(ele->ele.toUpperCase());
        System.out.println(capitalisedStream.collect(Collectors.toList()));

        // Reducing
        List<Integer> integers = Arrays.asList(1, 1, 1, 1);
        Integer reduced = integers.stream().reduce(10, (a, b) -> a + b);
        System.out.println(reduced);

        // Other examples
        // https://stackify.com/streams-guide-java-8/

    }
}

package com.app.reference;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeConversionDemo implements Solution {
    @Override
    public void execute() {

        convertInt();
        convertChar();
        convertDouble();

    }

    public static void convertInt() {
        int[] intArray = {1, 2, 3, 4};

        // int[] to IntStream
        IntStream intStream = Arrays.stream(intArray);

        // IntStream to ArrayList<Integer>
        ArrayList<Integer> intList = intStream.boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        // int[] to ArrayList<Integer> directly
        ArrayList<Integer> intListDirect = new ArrayList<>(Arrays.stream(intArray).boxed().toList());

        // ArrayList<Integer> to int[]
        int[] backToArray = intList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // ArrayList<Integer> to Stream<Integer>
        Stream<Integer> integerStream = intList.stream();

        System.out.println("Integer conversions done.");
    }

    public static void convertChar() {
        char[] charArray = {'a', 'b', 'c'};

        // char[] to Stream<Character>
        Stream<Character> charStream = IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[i]);

        // Stream<Character> to ArrayList<Character>
        ArrayList<Character> charList = charStream.collect(Collectors.toCollection(ArrayList::new));

        // char[] to ArrayList<Character> directly
        ArrayList<Character> charListDirect = IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[i])
                .collect(Collectors.toCollection(ArrayList::new));

        // ArrayList<Character> to char[]
        char[] backToArray = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            backToArray[i] = charList.get(i);
        }

        // ArrayList<Character> to Stream<Character>
        Stream<Character> characterStream = charList.stream();

        System.out.println("Character conversions done.");
    }

    public static void convertDouble() {
        double[] doubleArray = {1.1, 2.2, 3.3};

        // double[] to DoubleStream
        DoubleStream doubleStream = Arrays.stream(doubleArray);

        // DoubleStream to ArrayList<Double>
        ArrayList<Double> doubleList = doubleStream.boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        // double[] to ArrayList<Double> directly
        ArrayList<Double> doubleListDirect = new ArrayList<>(Arrays.stream(doubleArray)
                .boxed()
                .toList());

        // ArrayList<Double> to double[]
        double[] backToArray = doubleList.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();

        // ArrayList<Double> to Stream<Double>
        Stream<Double> doubleStreamBoxed = doubleList.stream();

        System.out.println("Double conversions done.");
    }

}

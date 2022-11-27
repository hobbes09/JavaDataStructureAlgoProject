package com.app.reference;

import com.app.Solution;

import java.util.Arrays;
import java.util.Iterator;

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

    }
}

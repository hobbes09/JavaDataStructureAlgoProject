package com.app.leetcode;

// https://leetcode.com/problems/set-intersection-size-at-least-two/

import com.app.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class SetIntersectionSize implements Solution {

    public int intersectionSizeTwo(int[][] intervals) {

        if(intervals.length == 1) {
            return 2;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });

        System.out.println(intervals);


        return 0;
    }

    @Override
    public void execute() {

        int[][] arr = {{1,3},{1,4},{2,5},{3,5}};

        System.out.println(intersectionSizeTwo(arr));
    }
}

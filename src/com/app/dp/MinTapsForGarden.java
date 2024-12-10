package com.app.dp;

import com.app.Solution;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

public class MinTapsForGarden implements Solution {

    public int minTaps(int n, int[] ranges) {

        int[][] rangePoints = new int[ranges.length*2][2];

        for (int i=0; i<ranges.length; i++) {
            int rangeLeft = i-ranges[i];
            int rangeRight = i+ranges[i];
            int idx = i*2;
            rangePoints[idx] = new int[]{rangeLeft, i};
            rangePoints[idx+1] = new int[]{rangeRight, i};
        }

        Arrays.sort(rangePoints, (r1, r2)->{
            return (r1[0] == r2[0]) ? r2[1] - r1[1] : r1[0] - r2[0];
        });


        return -1;
    }

    @Override
    public void execute() {
        System.out.println(minTaps(5, new int[]{3,4,1,1,0,0}));
    }
}

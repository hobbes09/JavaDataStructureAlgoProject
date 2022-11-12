package com.app.leetcode;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

// https://leetcode.com/problems/merge-intervals/

public class MergeArrIntervals implements Solution {
    @Override
    public void execute() {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });

        ArrayList<int[]> out = new ArrayList<>();
        out.add(intervals[0]);
        int lastIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= out.get(lastIndex)[0] && intervals[i][0] <= out.get(lastIndex)[1]) {
                int[] lastEntry = out.remove(lastIndex);
                out.add(new int[]{lastEntry[0], Math.max(lastEntry[1], intervals[i][1])});
            } else {
                out.add(intervals[i]);
                lastIndex++;
            }
        }

        int[][] res = out.toArray(new int[out.size()][]);

        for (int i =0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }


    }
}

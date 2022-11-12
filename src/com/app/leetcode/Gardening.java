package com.app.leetcode;

import com.app.Solution;

import java.util.*;

public class Gardening implements Solution {
    @Override
    public void execute() {

        int n = 7;
        int[] ranges = {3,4,1,1,0,0};

        System.out.println(minTaps(n, ranges));
    }

    public int minTaps(int n, int[] ranges) {

        int[][] tapRanges = new int[ranges.length][3];
        int countTap = 0;

        for (int i = 0; i < ranges.length; i++) {
            tapRanges[i][0] = i;
            tapRanges[i][1] = (i - ranges[i]) < 0 ? 0 : (i - ranges[i]);
            tapRanges[i][2] = i + ranges[i];
        }

        Arrays.sort(tapRanges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[2] - o1[2] : o1[1] - o2[1];
            }
        });

        if (tapRanges[0][1] > 0) {
            return -1;
        }
        int alreadyCovered = tapRanges[0][2];
        int tapCount = 1;
        for (int iTap = 1; iTap < tapRanges.length; iTap++) {
            if (alreadyCovered >= n) {
                return tapCount; 
            }
            if (tapRanges[iTap][1] - alreadyCovered > 1) {
                return -1;
            }
            if ( tapRanges[iTap][1] == tapRanges[iTap][2] && tapRanges[iTap][1] > alreadyCovered)
                return -1;

            if ( tapRanges[iTap][1] <= alreadyCovered+1) {
                if (tapRanges[iTap][2] > alreadyCovered) {
                    tapCount++;
                    alreadyCovered = tapRanges[iTap][2];
                }
            }
        }

        return tapCount;
    }
}

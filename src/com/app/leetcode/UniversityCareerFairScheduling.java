package com.app.leetcode;

// https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair

import com.app.Solution;

import java.util.Arrays;

public class UniversityCareerFairScheduling implements Solution {
    @Override
    public void execute() {

        int[] arrival1 = {1,3,3,5,7};
        int[] duration1 = {2,2,1,2,1};
        // [1,3], [3,5], [3,4], [5,7], [7,8]
        System.out.println(num_maxEvents(arrival1, duration1));

    }

    public static int num_maxEvents (int[] arr, int[]dur) {
        int drop = 0;
        int NumOfEvents = arr.length;
        int [][] intervals = new int[NumOfEvents][2];

        for (int i = 0; i < NumOfEvents; i++) {
            intervals[i] = new int[] {arr[i], arr[i] + dur[i]};
        }

        Arrays.sort(intervals, (a, b) ->(a[1] - b[1]));
        // the finish time of first event;
        int[] curEvent = intervals[0];

        for (int i = 1; i < NumOfEvents; i++) {
            int[] nextEvent = intervals[i];
            if (nextEvent[0] < curEvent[1]) {
                drop++;
                curEvent = (curEvent[1] < nextEvent[1]) ? curEvent : nextEvent;
            } else {
                curEvent = nextEvent;
            }
        }
        return NumOfEvents - drop;
    }
}

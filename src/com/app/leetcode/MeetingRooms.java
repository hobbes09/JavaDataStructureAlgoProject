package com.app.leetcode;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRooms implements Solution {
    @Override
    public void execute() {

        int[][] intervals = {{15, 20}, {0, 30}, {5, 10}};
        ArrayList<Integer> inSession = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for (int i=0; i< intervals.length; i++) {
            // System.out.println(intervals[i][0] + "--" + intervals[i][1]);
            if (inSession.isEmpty()) {
                inSession.add(i);
            } else {
                // Eject expired meeting
                // Add new meetings
                // Note max size
            }
        }



    }
}

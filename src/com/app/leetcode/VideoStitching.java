package com.app.leetcode;

import com.app.Solution;

import java.util.*;

// https://leetcode.com/problems/video-stitching/description/
public class VideoStitching implements Solution {

    TreeMap<Integer, PriorityQueue<Integer>> startToSortedEndTimesMap = new TreeMap<>();

    public int videoStitching(int[][] clips, int time) {

        int currentStartTime=0, videoEndTime=time, count=0;
        for (int[] clip : clips) {
            PriorityQueue<Integer> descendingSortedEndTimes = startToSortedEndTimesMap.getOrDefault(clip[0],
                    new PriorityQueue<>((e1,e2)->{
                        return e2-e1;
                    }));
            descendingSortedEndTimes.add(clip[1]);
            startToSortedEndTimesMap.put(clip[0], descendingSortedEndTimes);
        }
        while (currentStartTime < videoEndTime) {
            Map.Entry<Integer, PriorityQueue<Integer>> entry = startToSortedEndTimesMap.floorEntry(currentStartTime);
            currentStartTime = entry.getValue().poll();
            count++;
        }
        return count;
    }

    @Override
    public void execute() {
        System.out.println(videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10));
    }
}

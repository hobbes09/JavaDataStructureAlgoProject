package com.app.leetcode;

// https://leetcode.com/problems/partition-array-into-disjoint-intervals/

import com.app.Solution;

public class PartitionArrayIntoDisjointIntervals implements Solution {
    @Override
    public void execute() {

        int[] nums = {32,57,24,19,0,24,49,67,87,87};
        int[] maxTillNowFromLeft = new int[nums.length];
        int[] minTillNowFromRight = new int[nums.length];

        maxTillNowFromLeft[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            maxTillNowFromLeft[i] = nums[i] > maxTillNowFromLeft[i-1] ? nums[i] : maxTillNowFromLeft[i-1];
        }
        minTillNowFromRight[nums.length - 1] = nums[nums.length - 1];
        for (int i=nums.length-2; i>=0; i--) {
            minTillNowFromRight[i] = nums[i] < minTillNowFromRight[i+1] ? nums[i] : minTillNowFromRight[i+1];
        }

        if (nums.length == 2) {
            System.out.println(1);
        }

        int j = 0;
        for (j=0; j<nums.length-1;j++) {
            if (maxTillNowFromLeft[j] < minTillNowFromRight[j+1])
                break;
        }

        System.out.println(j+1);
    }
}

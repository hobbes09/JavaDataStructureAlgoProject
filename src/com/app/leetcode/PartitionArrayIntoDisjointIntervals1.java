package com.app.leetcode;

// https://leetcode.com/problems/partition-array-into-disjoint-intervals/

import com.app.Solution;

public class PartitionArrayIntoDisjointIntervals1 implements Solution {
    @Override
    public void execute() {

        int[] nums = {6,0,8,30,37,6,75,98,39,90,63,74,52,92,64};
        int N = nums.length;
        int[] maxLeft = new int[N];
        int[] minRight = new int[N];

        maxLeft[0] = nums[0];
        minRight[N - 1] = nums[N - 1];

        for (int i = 1; i < N; ++i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }

        for (int i = N - 2; i >= 0; --i) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }

        for (int i = 1; i < N; ++i) {
            if (maxLeft[i - 1] <= minRight[i]) {
                System.out.println(i);
            }
        }
        // In case there is no solution, we'll return -1
        System.out.println(-1);
    }
}

package com.app.dp;

// https://leetcode.com/problems/maximum-subarray/

import com.app.Solution;

public class MaximumSubArray implements Solution {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int i=0, j=0;
        int currSum = nums[0], maxSum = Integer.MIN_VALUE;

        while(i<len && j<=i) {
            if (currSum < 0) {
                if (i==j) {
                    i++;j++;
                    currSum= (i<len) ? nums[i] : currSum;
                } else {
                    currSum= (j<len) ? currSum-nums[j] : currSum;
                    j++;
                }
            } else {
                i++;
                currSum= (i<len) ? currSum+nums[i] : currSum;
            }

            maxSum=(currSum>maxSum)?currSum:maxSum;
        }
        return maxSum;
    }

    @Override
    public void execute() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}

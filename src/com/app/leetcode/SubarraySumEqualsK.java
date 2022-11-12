package com.app.leetcode;

import com.app.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/subarray-sum-equals-k/

public class SubarraySumEqualsK implements Solution {
    @Override
    public void execute() {

        System.out.println(subArraySum(new int[]{1,1,1}, 2));
    }

    public int subArraySum(int[] nums, int k) {

        HashMap<Integer, List<Integer>> prefixSumMap = new HashMap<>();

        int count = 0;
        int sumTillNow = 0;
        for (int i=0; i<nums.length; i++) {
            sumTillNow += nums[i];
            List<Integer> indexes = prefixSumMap.getOrDefault(sumTillNow, new ArrayList<>());
            indexes.add(i);
            prefixSumMap.put(sumTillNow, indexes);

            int diff = sumTillNow - k;
            if (diff == 0)
                count++;
            if (prefixSumMap.containsKey(diff)) {
                int finalI = i;
                count+=prefixSumMap.get(diff).stream().filter(a -> a!= finalI).count();
            }
        }

        return count;
    }

}

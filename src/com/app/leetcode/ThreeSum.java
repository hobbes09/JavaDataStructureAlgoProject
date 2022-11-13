package com.app.leetcode;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum implements Solution {

    // https://leetcode.com/problems/3sum/
    @Override
    public void execute() {

        List<List<Integer>> solutions = new ArrayList<>();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (map.containsKey(-1*sum)) {
                List<Integer> sol = new ArrayList<>();
                sol.add(nums[start]);
                sol.add(nums[end]);
                sol.add(-1*sum);
                solutions.add(sol);
            }
        }
        System.out.println(solutions);
    }
}

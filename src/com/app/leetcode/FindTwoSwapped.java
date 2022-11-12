package com.app.leetcode;

import com.app.Solution;

import java.util.Iterator;
import java.util.TreeSet;

// https://leetcode.com/problems/recover-binary-search-tree/solution/

public class FindTwoSwapped implements Solution {
    @Override
    public void execute() {

        int[] nums = {2,1,3,4};

        int n = nums.length;
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums[i + 1] < nums[i]) {
                y = nums[i + 1];
                // first swap occurence
                if (x == -1) x = nums[i];
                    // second swap occurence
                else break;
            }
        }

    }
}

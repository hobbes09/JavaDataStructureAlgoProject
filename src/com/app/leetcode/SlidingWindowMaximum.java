package com.app.leetcode;

import com.app.Solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/sliding-window-maximum/

public class SlidingWindowMaximum implements Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }

    @Override
    public void execute() {
        //int[] windowMax = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7} , 3);
        int[] windowMax = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7} , 3);
        System.out.println(Arrays.toString(windowMax));
    }
}

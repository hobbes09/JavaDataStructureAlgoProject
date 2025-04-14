package com.app.leetcode;

import com.app.Solution;

import java.util.PriorityQueue;


// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/editorial/#overview

public class LongestContinuousSubarrayWithLimitDiff implements Solution {

    private class ArrElem {
        int index;
        int value;

        public ArrElem(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    @Override
    public void execute() {

        int[] nums = new int[]{10,1,2,4,7,2};
        int limit = 5;

        printLongestContinuousSubarrayWithLimitDiff(nums, limit);

    }

    private void printLongestContinuousSubarrayWithLimitDiff(int[] nums, int limit) {

        int left=0, right=0;
        PriorityQueue<ArrElem> minHeap = new PriorityQueue<>((a,b)->{return a.value - b.value;});
        PriorityQueue<ArrElem> maxHeap = new PriorityQueue<>((a,b)->{return b.value - a.value;});



    }
}

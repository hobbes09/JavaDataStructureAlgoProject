package com.app.leetcode;

import com.app.Solution;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class LongestContSubarrayWithDiffLimit implements Solution {

    class HeapNode {
        int value;
        int index;

        public HeapNode(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((n1, n2)->{
        return n1.value - n2.value;
    });

    PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((n1, n2)->{
        return n2.value - n1.value;
    });

    public int longestSubarray(int[] nums, int limit) {

        int start = 0, end = 0, maxDiff=1;
        minHeap.add(new HeapNode(nums[0], 0));
        maxHeap.add(new HeapNode(nums[0], 0));
        while(end < nums.length-1) {
            int newElementIndex = end+1;
            int newElement = nums[newElementIndex];
            int currentMin = getCurrentMinInWindow(nums, start, end);
            int currentMax = getCurrentMaxInWindow(nums, start, end);

            if (checkNewElementIsWithinLimits(newElement, currentMin, currentMax, limit)) {
                end = updateWindowEnd(end, nums);
            } else {
                end = end==start?updateWindowEnd(end, nums):end;
                start++;
            }
            maxDiff = ((end-start+1) > maxDiff) ? end-start+1: maxDiff;
        }

        return maxDiff;
    }

    private int updateWindowEnd(int end, int[] nums) {
        end++;
        minHeap.add(new HeapNode(nums[end], end));
        maxHeap.add(new HeapNode(nums[end], end));
        return end;
    }

    private boolean checkNewElementIsWithinLimits(int newElement, int currentMin, int currentMax, int limit) {
        if (newElement-currentMin > limit || currentMax-newElement > limit)
            return false;
        return true;
    }

    private int getCurrentMaxInWindow(int[] nums, int start, int end) {
        while (!maxHeap.isEmpty()) {
            HeapNode apparentMaxNode = maxHeap.peek();
            if (apparentMaxNode.index < start || apparentMaxNode.index > end){
                maxHeap.poll();
            } else {
                return apparentMaxNode.value;
            }
        }
        return nums[end];
    }

    private int getCurrentMinInWindow(int[] nums, int start, int end) {
        while (!minHeap.isEmpty()) {
            HeapNode apparentMinNode = minHeap.peek();
            if (apparentMinNode.index < start || apparentMinNode.index > end){
                minHeap.poll();
            } else {
                return apparentMinNode.value;
            }
        }
        return nums[start];
    }

    @Override
    public void execute() {
        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}

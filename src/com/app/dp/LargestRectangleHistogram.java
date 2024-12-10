package com.app.dp;

import com.app.Solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleHistogram implements Solution {

    public int largestRectangleArea(int[] heights){

        int maxArea = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int index=0; index<heights.length; index++) {
            while (!stack.isEmpty() && heights[index] < heights[stack.peek()]) {
                int localHeight = heights[stack.peek()];
                int localWidth = index - stack.pop();
                int localArea = localWidth*localHeight;
                maxArea = (localArea>maxArea)?localArea:maxArea;
            }
            stack.push(index);
        }
        while (!stack.isEmpty()) {
            int localHeight = heights[stack.peek()];
            int localWidth = heights.length - stack.pop();
            int localArea = localWidth*localHeight;
            maxArea = (localArea>maxArea)?localArea:maxArea;
        }
        return maxArea;
    }

    @Override
    public void execute() {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

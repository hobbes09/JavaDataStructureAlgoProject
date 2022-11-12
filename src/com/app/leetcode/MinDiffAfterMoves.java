package com.app.leetcode;

import com.app.Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDiffAfterMoves implements Solution {

    @Override
    public void execute() {
        minDifference(new int[]{1,5,0,10,14});
    }

    public int minDifference(int[] nums) {

        PriorityQueue<Integer> minimumHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        PriorityQueue<Integer> maximumHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int num : nums) {
            maximumHeap.add(num);
            if (maximumHeap.size() > 3) {
                int out = maximumHeap.poll();
                System.out.println(out);
            }
            minimumHeap.add(num);
            if (minimumHeap.size() > 3) {
                int out = minimumHeap.poll();
                System.out.println(out);
            }
        }

        return 0;
    }
}

package com.app.leetcode;

import com.app.Solution;

import java.util.PriorityQueue;

//

public class Problem1FactoryPollution implements Solution {
    @Override
    public void execute() {

        int[] A = {5, 19, 8, 1};
        int totalFactories = A.length;
        int totalPollution = 0;

        if (totalFactories == 0)
            System.out.println(0);;

        PriorityQueue<Integer> priorityFactoryPollutions=new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int idx=0; idx<totalFactories; idx++){
            totalPollution+=A[idx];
            priorityFactoryPollutions.offer(A[idx]);
        }
        int minTargetPollution=totalPollution/2;
        int sumLeft=totalPollution;
        int countFilters=0;
        while (sumLeft>minTargetPollution && !priorityFactoryPollutions.isEmpty()){
            int high=priorityFactoryPollutions.poll();
            sumLeft = sumLeft - high;
            high/=2;
            priorityFactoryPollutions.offer(high);
            sumLeft=sumLeft+high;
            countFilters+=1;
        }
        System.out.println(countFilters);

    }
}

package com.app.dp;

import com.app.Solution;
import java.util.*;

/*

 */

public class KnapsackProblem implements Solution {

    public int getMaximumKnapsackValue(int[] weights, int[] values, int TotalWeight) {

        int[][] knapsack = new int[values.length + 1][TotalWeight+1];

        for (int itemIndex = 0; itemIndex <= weights.length; itemIndex++) {
            for (int wtLimit = 0; wtLimit <= TotalWeight; wtLimit++) {
                if (itemIndex == 0 || wtLimit == 0)
                    knapsack[itemIndex][wtLimit] = 0;
                else if (weights[itemIndex - 1] <= wtLimit)
                    knapsack[itemIndex][wtLimit] = max(
                            values[itemIndex - 1] + knapsack[itemIndex - 1][wtLimit - weights[itemIndex - 1]],
                            knapsack[itemIndex - 1][wtLimit]);
                else
                    knapsack[itemIndex][wtLimit] = knapsack[itemIndex - 1][wtLimit];
            }
        }

        return knapsack[weights.length][TotalWeight];
    }

    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    @Override
    public void execute() {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(getMaximumKnapsackValue(wt, val, W));
    }
}

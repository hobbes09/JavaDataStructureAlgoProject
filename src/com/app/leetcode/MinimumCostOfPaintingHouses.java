package com.app.leetcode;

// https://leetcode.com/problems/paint-house/

import com.app.Solution;

public class MinimumCostOfPaintingHouses implements Solution {

    int[][] paintCosts;

    @Override
    public void execute() {

        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        paintCosts = new int[costs.length][3];

        int minCot = Math.min(
                getMinCost( costs,1, new int[]{1,2}) + costs[0][0],
                Math.min(getMinCost(costs, 1, new int[]{0,2}) + costs[0][1], getMinCost(costs, 1, new int[]{0,1}) + costs[0][2])
        );
        System.out.println(minCot);
    }

    private int getMinCost(int[][] costs, int rowIndex, int[] choiceOptions) {

        int maxRowIndex = costs.length - 1;
        if (rowIndex > maxRowIndex) {
            return 0;
        }
        if (rowIndex == maxRowIndex) {
            return Math.min(costs[rowIndex][choiceOptions[0]], costs[rowIndex][choiceOptions[1]]);
        }

        return Math.min(
                getMinCost( costs,rowIndex+1, new int[]{1,2}) + costs[rowIndex][0],
                Math.min(getMinCost(costs, rowIndex+1, new int[]{0,2}) + costs[rowIndex][1], getMinCost(costs, rowIndex+1, new int[]{0,1}) + costs[rowIndex][2]));
    }
}

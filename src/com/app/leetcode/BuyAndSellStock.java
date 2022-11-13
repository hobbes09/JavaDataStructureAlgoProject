package com.app.leetcode;

import com.app.Solution;

public class BuyAndSellStock implements Solution {

    @Override
    public void execute() {

        int[] prices = {7,1,5,3,6,4};
        int minSoFar = prices[0];
        int maxProfitSoFar = 0;

        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - minSoFar;
            maxProfitSoFar = profit > maxProfitSoFar ? profit : maxProfitSoFar;
            minSoFar = prices[i] < minSoFar ? prices[i] : minSoFar;
        }

        System.out.println(maxProfitSoFar);
    }
}

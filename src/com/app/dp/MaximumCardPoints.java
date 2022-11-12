package com.app.dp;

import com.app.Solution;

public class MaximumCardPoints implements Solution {

    public int maxScore(int[] cardPoints, int k) {

        if (cardPoints == null || cardPoints.length == 0) {
            return 0;
        }
        return maxPointBetweenRange(cardPoints, 0, cardPoints.length - 1, k);
    }

    private int maxPointBetweenRange(int[] cardPoints, int left, int right, int k) {

        if (left > right) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        if (left == right) {
            return cardPoints[left];
        }
        if (k == 1) {
            return Math.max(cardPoints[left], cardPoints[right]);
        }
        if (right == left+1 && k > 1) {
            return cardPoints[left] + cardPoints[right];
        }

        int leftOption = cardPoints[left] + maxPointBetweenRange(cardPoints, left+1, right, k-1);
        int rightOption = cardPoints[right] + maxPointBetweenRange(cardPoints, left, right-1, k-1);
        return Math.max(leftOption, rightOption);
    }

    @Override
    public void execute() {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        System.out.println(maxScore(cardPoints, 3));
    }
}

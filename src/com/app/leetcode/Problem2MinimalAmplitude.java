package com.app.leetcode;

import com.app.Solution;

public class Problem2MinimalAmplitude implements Solution {
    @Override
    public void execute() {

        int[] A = {5,3,6,1,3};
        int K = 2;
        int total = A.length;
        int minAmplitude = Integer.MAX_VALUE;

        int[] prefixMin = new int[total];
        int[] prefixMax = new int[total];
        int[] suffixMin = new int[total];
        int[] suffixMax = new int[total];

        prefixMin[0] = A[0];
        prefixMax[0] = A[0];
        for (int i=1; i<total; i++) {
            prefixMin[i] = A[i] < prefixMin[i-1] ? A[i] : prefixMin[i-1];
            prefixMax[i] = A[i] > prefixMax[i-1] ? A[i] : prefixMax[i-1];
        }

        suffixMin[total-1] = A[total-1];
        suffixMax[total-1] = A[total-1];
        for (int i=total-2; i>=0; i--) {
            suffixMin[i] = A[i] < suffixMin[i+1] ? A[i] : suffixMin[i+1];
            suffixMax[i] = A[i] > suffixMax[i+1] ? A[i] : suffixMax[i+1];
        }

        for (int i=0; i<=total-K; i++) {
            int max=0;
            int min = 0;
            if (i == 0) {
                max = suffixMax[i+K];
                min = suffixMin[i+K];
            } else if (i == total-K) {
                max = prefixMax[i-1];
                min = prefixMin[i-1];
            } else {
                max = Math.max(prefixMax[i-1], suffixMax[i+K]);
                min = Math.min(prefixMin[i-1], suffixMin[i+K]);
            }
            minAmplitude = max-min < minAmplitude ? max-min : minAmplitude;
        }

        System.out.println(minAmplitude);

    }
}

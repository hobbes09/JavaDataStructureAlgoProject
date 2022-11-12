package com.app.reference;

import com.app.Solution;

public class SubArraySumEqualsK implements Solution {

    @Override
    public void execute() {

        int[] arr = {1,2,3};
        int k = 3;

        int l = 0, r = 0;
        int sum = arr[l];
        int count = 0;

        int[] preSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                preSum[0] = arr[0]; continue;
            } else {
                preSum[i] = arr[i] + preSum[i-1];
            }
        }


        while (l <= r && r < arr.length) {

            if (l == r) {
                if ( arr[l] > k) {
                    l++;r++;
                } else if (arr[l] == k) {
                    System.out.println("left=" + l + " right=" + r);
                    count++;l++;r++;
                } else {
                    r++;
                }
            } else {

                int sumTillNow = 0;
                if (l>=1) {
                    sumTillNow = preSum[r] - preSum[l-1];
                } else {
                    sumTillNow = preSum[r];
                }

                if (sumTillNow == k) {
                    System.out.println("left=" + l + " right=" + r);
                    count++;r++;
                } else if (sumTillNow < k) {
                    r++;
                }else {
                    l++;
                }
            }
        }

        System.out.println("output = " + count);
    }
}

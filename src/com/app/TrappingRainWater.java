package com.app;

import java.util.ArrayList;

public class TrappingRainWater implements Solution {

    public int calculateAmountOfRainWaterTrapped(int[] arr) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.stream().toArray();
        int[] leftMaxIncluding = new int[arr.length];
        int[] rightMaxIncluding = new int[arr.length];

        int leftMaxTillNow = arr[0];
        leftMaxIncluding[0] = leftMaxTillNow;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > leftMaxTillNow) {
                leftMaxTillNow = arr[i];
            }
            leftMaxIncluding[i] = leftMaxTillNow;
        }
        int rightMaxTillNow = arr[arr.length - 1];
        rightMaxIncluding[arr.length - 1] = rightMaxTillNow;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > rightMaxTillNow) {
                rightMaxTillNow = arr[i];
            }
            rightMaxIncluding[i] = rightMaxTillNow;
        }

        int total = 0;
        for (int i = 1; i <= arr.length - 2; i++) {
            int levelWater = waterTrappedAtThisLevel(arr[i], leftMaxIncluding[i-1], rightMaxIncluding[i+1]);
            total += levelWater;
        }
        return total;
    }

    private int waterTrappedAtThisLevel(int height, int leftMax, int rightMax) {
        int min = leftMax;
        if (rightMax < min) {
            min = rightMax;
        }
        if (min > height) {
            return min - height;
        }
        return 0;
    }

    @Override
    public void execute() {
        int[] arr = {1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(calculateAmountOfRainWaterTrapped(arr));
    }
}

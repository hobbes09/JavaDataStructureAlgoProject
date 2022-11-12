package com.app.reference;

import com.app.Solution;

public class BinarySearch implements Solution {

    public boolean search(int[] array, int start, int end, int k) {

        if (start > end) {
            return false;
        }
        if( start == end) {
            if (array[start] == k) {
                return true;
            }
            return false;
        }

        int midIndex = (end+start)/2;
        if (midIndex < start || midIndex > end) {
            return false;
        }
        if (array[midIndex] == k) {
            return true;
        }

        // start -- mid -- end
        boolean exists = false;

        if (k < array[midIndex] && midIndex - 1 >= start) {
            exists = search(array, start, midIndex - 1, k);
        }
        if (!exists && k > array[midIndex] && (midIndex + 1 <= end)) {
            exists = search(array, midIndex + 1, end, k);
        }
        return exists;
    }

    @Override
    public void execute() {
        int[] arr = {1,2,3,5};
        boolean res = search(arr, 0, arr.length-1, 5);
        System.out.println("Result : " + res);
    }
}

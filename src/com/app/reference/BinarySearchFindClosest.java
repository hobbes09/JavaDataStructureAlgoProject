package com.app.reference;

import com.app.Solution;

public class BinarySearchFindClosest implements Solution {

    public Integer search(int[] array, int start, int end, int k) {

        if (start > end) {
            return null;
        }
        if( start == end) {
            if (array[start] == k) {
                return k;
            }
            return k;
        }

        if (k <= array[start])
            return array[start];
        if (k >= array[end])
            return array[end];

        int midIndex = (end+start)/2;
        if (midIndex < start || midIndex > end) {
            return null;
        }
        if (array[midIndex] == k) {
            return k;
        }

        // start -- mid -- end
        if (k < array[midIndex] && midIndex - 1 >= start) {
            if (k < array[midIndex] && k > array[midIndex-1])
                return (Math.abs(k-array[midIndex]) > Math.abs(k-array[midIndex-1])) ? array[midIndex-1] : array[midIndex];
            return search(array, start, midIndex - 1, k);
        }
        if (k > array[midIndex] && (midIndex + 1 <= end)) {
            if (k > array[midIndex] && k < array[midIndex+1])
                return (Math.abs(k-array[midIndex]) > Math.abs(k-array[midIndex+1])) ? array[midIndex+1] : array[midIndex];
            return search(array, midIndex + 1, end, k);
        }
        return null;
    }

    @Override
    public void execute() {
        int[] arr = {1,12,23,54,65};
        Integer res = search(arr, 0, arr.length-1, 11);
        System.out.println("Result : " + res);
    }
}

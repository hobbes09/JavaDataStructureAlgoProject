package com.app.reference;

import com.app.Solution;

public class QuickSort implements Solution {

    class PartitionedArray {
        int[] arr; int pIndex;

        public PartitionedArray(int[] arr, int pIndex) {
            this.arr = arr;
            this.pIndex = pIndex;
        }
    }

    private int[] QuickSort(int[] arr, int l, int h) {
        if (l < h) {
            PartitionedArray partitionedArray = partition(arr, l, h);
            arr = partitionedArray.arr;
            int pIndex = partitionedArray.pIndex;

            arr = QuickSort(arr, l, pIndex - 1);
            arr = QuickSort(arr, pIndex+1, h);
        }
        return arr;
    }

    private PartitionedArray partition(int[] arr, int l, int h) {
        int localPivotIndex = l;
        int pivot = arr[localPivotIndex];
        int i = l+1, j = h;

        while (i < j) {

            while (arr[i] <= pivot && i < h) {
                i++;
            }
            while(arr[j] > pivot && j > l) {
                j--;
            }

            if (i < j) {
                arr = swap(arr, i, j);
            }
        }
        arr = swap(arr, localPivotIndex, j);
        return new PartitionedArray(arr, j);
    }

    private int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    @Override
    public void execute() {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        arr = QuickSort(arr, 0, arr.length-1);

        for(int i=1; i<arr.length; ++i){
            System.out.println(arr[i]);
        }
    }
}

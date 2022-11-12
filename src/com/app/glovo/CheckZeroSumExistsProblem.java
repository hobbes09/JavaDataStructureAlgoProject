package com.app.glovo;

import com.app.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class CheckZeroSumExistsProblem implements Solution {

    public boolean checkZeroSumExists(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        HashMap<Integer, LinkedList<Integer>> preSum = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                return true;
            }
            sum += arr[i];
            LinkedList<Integer> indexes = preSum.getOrDefault(sum, new LinkedList<>());
            indexes.add(i);
            preSum.put(sum, indexes);
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            LinkedList<Integer> indexes = preSum.getOrDefault(num, null);
            if (indexes != null && indexes.size() > 1) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void execute() {
        System.out.println(checkZeroSumExists(new int[]{4,2,-3,1,6}));
        System.out.println(checkZeroSumExists(new int[]{4,2,0,1,6}));
        System.out.println(checkZeroSumExists(new int[]{-3,2,3,1,6}));
    }
}

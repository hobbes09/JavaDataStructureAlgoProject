package com.app.leetcode;

import com.app.Solution;

import java.util.*;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class AllDuplicatesInAnArray implements Solution {
    @Override
    public void execute() {

        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums).toString());
    }

    public Set<Integer> findDuplicates(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new HashSet<>();
        }

        Set<Integer> duplicates = new LinkedHashSet<>();

        for (int i=0; i<nums.length; i++) {
            int element = nums[i];
            if (element < 0) {
                element = element * (-1);
            }
            int actualPositionElement = getElementInPosition(element, nums);
            if (actualPositionElement == element) {
                duplicates = addDuplicateNumber(element, duplicates);
                nums = markElementInPositionAsDuplicate(element, nums);
            } else if (element == -1 * actualPositionElement) {
                duplicates = addDuplicateNumber(element, duplicates);
                nums = markElementInPositionAsDuplicate(element, nums);
            } else if (actualPositionElement < 0) {
                duplicates = addDuplicateNumber(element, duplicates);
            } else if (actualPositionElement > 0) {
                nums[element - 1] = -1 * nums[element - 1];
            }
        }
        return duplicates;
    }

    private int getElementInPosition(int k, int[] nums) {
        return nums[k-1];
    }

    private int[] markElementInPositionAsDuplicate(int k, int[] nums) {
        if (nums[k-1] > 0) {
            nums[k-1] = -1 * nums[k-1];
        }
        return nums;
    }

    private Set<Integer> addDuplicateNumber(int k, Set<Integer> duplicates) {
        if (k < 0) {
            k *= -1;
        }
        duplicates.add(k);
        return duplicates;
    }
}
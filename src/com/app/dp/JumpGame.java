package com.app.dp;

import com.app.Solution;

public class JumpGame implements Solution {

    public int minJump(int[] nums) {

        int minJump[] = new int[nums.length];
        minJump[0] = 0;
        for(int i=1; i<nums.length; i++) {
            minJump[i] = Integer.MAX_VALUE;
            for (int j=0; j<i; j++) {
                if (nums[j] >= (i-j)) {
                    minJump[i] = (minJump[j] + 1 < minJump[i]) ? minJump[j] + 1 : minJump[i];
                }
            }
        }
        return minJump[nums.length-1];
    }

    @Override
    public void execute() {
        System.out.println(minJump(new int[]{2,3,1,1,4}));
    }
}

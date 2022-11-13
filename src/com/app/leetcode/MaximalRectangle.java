package com.app.leetcode;

import com.app.Solution;

public class MaximalRectangle implements Solution {

    @Override
    public void execute() {

        int[][] arr = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0},
        };

        int[][] arr1 = new int[arr.length][arr[0].length];

        for (int i = 0;  i  < arr.length; i++) {
            for (int j = arr[0].length - 1; j >= 0; j--) {

                if (arr[i][j] == 0) {
                    arr1[i][j] = 0;
                    continue;
                }

                if (j == arr[0].length - 1) {
                    arr1[i][j] = 1;
                    continue;
                }

                arr1[i][j] = arr1[i][j+1] + 1;
            }
        }

        //=====================================================

        for (int i = 0; i < arr1.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < arr1[i].length; j++) { //this equals to the column in each row.
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }

    }
}

package com.app.dp;

import com.app.Solution;

public class MatrixMinPathSum implements Solution {

    public int minPathSum(int[][] grid) {

        int[][] minSum = new int[grid.length][grid[0].length];
        minSum[0][0]=grid[0][0];
        for(int col=1; col<grid[0].length; col++) {
            minSum[0][col] = minSum[0][col-1] + grid[0][col];
        }
        for(int row=1; row<grid.length; row++) {
            minSum[row][0] = minSum[row-1][0] + grid[row][0];
        }
        for(int row=1; row<grid.length; row++) {
            for(int col=1; col<grid[0].length; col++) {
                minSum[row][col] = grid[row][col] + Math.min(minSum[row-1][col], minSum[row][col-1]);
            }
        }
        return minSum[grid.length-1][grid[0].length-1];
    }

    @Override
    public void execute() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}

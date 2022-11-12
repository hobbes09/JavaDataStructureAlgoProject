package com.app.reference.graph;

import com.app.Solution;

/*
https://leetcode.com/problems/number-of-provinces/
 */
public class ProvincesCount implements Solution {

    int[][] isConnected;
    int countProvinces;

    @Override
    public void execute() {

        isConnected = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 1 } };
        countProvinces = findCircleNum(isConnected);
        System.out.println(countProvinces);
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

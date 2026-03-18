package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] record = new int[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(i == 0 && j == 0){
                    record[i][j] = grid[i][j];
                }else if(i == 0){
                    record[i][j] = record[i][j - 1] + grid[i][j];
                }else if(j == 0){
                    record[i][j] = record[i - 1][j] + grid[i][j];
                }else{
                    record[i][j] = record[i - 1][j] + record[i][j - 1] - record[i - 1][j - 1] + grid[i][j];
                }

                if(record[i][j] <= k){
                    result += 1;
                }
            }
        }
        return result;
    }
}

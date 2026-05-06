package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3546 {
    public boolean canPartitionGrid(int[][] grid) {
        long[] record1 = new long[grid.length];
        long[] record2 = new long[grid[0].length];

        for(int i = 0;i < grid.length; ++i){
            long sum = 0;
            for(int j = 0;j < grid[0].length; ++j){
                sum += grid[i][j];
            }
            record1[i] = sum;
        }

        for(int j = 0;j < grid[0].length; ++j){
            long sum = 0;
            for(int i = 0;i < grid.length; ++i){
                sum += grid[i][j];
            }
            record2[j] = sum;
        }

        long[] sumRecord1 = new long[grid.length + 1];
        long[] sumRecord2 = new long[grid[0].length + 1];

        long sum = 0;
        sumRecord1[0] = 0;
        for(int i = 0;i < grid.length; ++i){
            sum += record1[i];
            sumRecord1[i + 1] = sum;
        }
        sum = 0;
        for(int j = grid.length - 1;j >= 0; --j){
            sum += record1[j];
            if(j != 0 && sum == sumRecord1[j]){
                return true;
            }
        }
        sum = 0;
        sumRecord2[0] = 0;
        for(int i = 0;i < grid[0].length; ++i){
            sum += record2[i];
            sumRecord2[i + 1] = sum;
        }
        sum = 0;
        for(int j = grid[0].length - 1;j >= 0; --j){
            sum += record2[j];
            if(j != 0 && sum == sumRecord2[j]){
                return true;
            }
        }

        return false;
    }
}

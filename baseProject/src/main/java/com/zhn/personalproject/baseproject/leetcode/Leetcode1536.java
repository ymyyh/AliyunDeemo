package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode1536 {
    public int minSwaps(int[][] grid) {
        int[] record = new int[grid.length];
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    record[i] = j;
                }
            }
        }
        int temp1, temp2;
        int count = 0;
        for(int i = 0;i < grid.length; ++i){
            temp1 = record[i];
            for(int j = i; j < grid.length; ++j){
                if(record[j] <= i){
                    record[i] = record[j];
                    record[j] = temp1;

                    count += j - i;
                    break;
                }else{
                    temp2 = temp1;
                    temp1 = record[j];
                    record[j] = temp2;
                }

                if(j == grid.length - 1){
                    return -1;
                }
            }
        }

        return count;
    }
}

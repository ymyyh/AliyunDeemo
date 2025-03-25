package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] arr1 = new int[grid.length][grid[0].length];
        int[][] arr2 = new int[grid.length][grid[0].length];
        int[][] result = new int[grid.length][grid[0].length];

        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                int m = i - 1;
                int n = j - 1;
                Set<Integer> tempSet = new HashSet<>();
                while(m >= 0 && n >= 0){
                    tempSet.add(grid[m][n]);
                    m -= 1;
                    n -= 1;
                }
                arr1[i][j] = tempSet.size();

                m = i + 1;
                n = j + 1;
                tempSet.clear();
                while(m < grid.length && n < grid[0].length){
                    tempSet.add(grid[m][n]);
                    m += 1;
                    n += 1;
                }
                arr2[i][j] = tempSet.size();
            }
        }
        for(int i = 0;i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = Math.abs(arr1[i][j] - arr2[i][j]);
            }
        }

        return result;
    }
}

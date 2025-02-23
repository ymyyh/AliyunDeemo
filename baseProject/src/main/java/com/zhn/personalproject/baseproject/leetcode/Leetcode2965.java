package com.zhn.personalproject.baseproject.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum = (1 + grid.length * grid.length) * grid.length * grid.length / 2;
        Set<Integer> numSet = new HashSet<>();
        int[] result = new int[2];
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(!numSet.contains(grid[i][j])){
                    numSet.add(grid[i][j]);
                    sum -= grid[i][j];
                }
                else{
                    result[0] = grid[i][j];
                }
            }
        }
        result[1] = (int) sum;
        return result;
    }
}

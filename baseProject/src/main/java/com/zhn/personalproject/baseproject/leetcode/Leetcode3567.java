package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {

        int[][] result = new int[grid.length - k + 1][grid[0].length - k + 1];
        Set<Integer> record = new HashSet<>();

        for(int i = k - 1;i < grid.length; ++i){
            for(int j = k - 1;j < grid[0].length; ++j) {
                if (k != 1) {
                    record.clear();
                    for (int m = 0; m < k; ++m) {
                        for (int n = 0; n < k; ++n) {
                            record.add(grid[i - m][j - n]);
                        }
                    }
                    if(record.size() == 1){
                        result[i - k + 1][j - k + 1] = 0;
                        continue;
                    }

                    List<Integer> tempList = new ArrayList<>(record);
                    Collections.sort(tempList);
                    int min = Integer.MAX_VALUE;
                    for (int p = 0; p < record.size() - 1; ++p) {
                        min = Math.min(min, Math.abs(tempList.get(p) - tempList.get(p + 1)));
                    }
                    result[i - k + 1][j - k + 1] = min;
                } else {
                    result[i - k + 1][j - k + 1] = 0;
                }
            }
        }

        return result;
    }
}

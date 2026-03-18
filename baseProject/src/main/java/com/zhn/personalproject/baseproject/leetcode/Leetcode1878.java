package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode1878 {
    public int[] getBiggestThree(int[][] grid) {
        int minRow = 0, maxRow = grid.length - 1, minCol = 0, maxCol = grid[0].length - 1;
        Set<Integer> record = new HashSet<>();
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j) {
                record.add(grid[i][j]);
                int lengthSum = Math.min(i - minRow, Math.min(maxRow - i, (maxCol - j) / 2));
                for (int length = 1;length <= lengthSum; ++length) {
                    int row = i, col = j, sum = 0;
                    for (int m = 0; m < length; ++m) {
                        sum += grid[row][col];
                        row -= 1;
                        col += 1;
                    }
                    for (int m = 0; m < length; ++m) {
                        sum += grid[row][col];
                        row += 1;
                        col += 1;
                    }
                    for (int m = 0; m < length; ++m) {
                        sum += grid[row][col];
                        row += 1;
                        col -= 1;
                    }
                    for (int m = 0; m < length; ++m) {
                        sum += grid[row][col];
                        row -= 1;
                        col -= 1;
                    }
                    record.add(sum);
                }
            }
        }
        int[] result = new int[Math.min(record.size(), 3)];
        int a = -1, b = -1, c = -1;
        for(int num : record){
            if(num > a){
                c = b;
                b = a;
                a = num;
            }else if(num > b){
                c = b;
                b = num;
            }else if(num > c){
                c = num;
            }
        }
        if(a > 0){
            result[0] = a;
        }
        if(b > 0){
            result[1] = b;
        }
        if(c > 0){
            result[2] = c;
        }
        return result;
    }
}

package com.zhn.personalproject.baseproject.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for(int i = 0;i < 2 * n - 1; ++i){
            int min = Math.max(0, i + 1 - n);
            int max = Math.min(i, n - 1);
            List<Integer> list = new ArrayList<>();
            int column = Math.max(n - 1 - i, 0);
            for(int j = min;j <= max; ++j){
                list.add(grid[j][column]);
                column += 1;
            }
            if(i < n - 1){
                list.sort((a, b) -> a - b);
            }else{
                list.sort((a, b) -> b - a);
            }
            int k = 0;
            column = Math.max(n - 1 - i, 0);
            for(int j = min;j <= max; ++j){
                grid[j][column] = list.get(k);
                k += 1;
                column += 1;
            }
        }
        return grid;
    }
}

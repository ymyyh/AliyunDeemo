package com.zhn.personalproject.baseproject.leetcode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        int orangeNum = 0;
        int badOrangeNum = 0;
        int time = 0;
        Queue<orange> queue = new LinkedList<>();
        for(int i = 0;i < grid.length; ++i){
            for(int j = 0;j < grid[0].length; ++j){
                if(grid[i][j] != 0){
                    orangeNum += 1;
                    if(grid[i][j] == 2){
                        queue.offer(new orange(i, j, 0));
                    }
                }
            }
        }
        int layer;
        int col;
        int row;
        while(!queue.isEmpty()){
            orange tempOrange = queue.poll();
            badOrangeNum += 1;
            time = Math.max(time, tempOrange.layer);
            row = tempOrange.row;
            col = tempOrange.col;
            layer = tempOrange.layer;
            if(row > 0 && grid[row - 1][col] == 1){
                queue.offer(new orange(row - 1, col, layer + 1));
                grid[row - 1][col] = 2;
            }
            if(row < grid.length - 1 && grid[row + 1][col] == 1){
                queue.offer(new orange(row + 1, col, layer + 1));
                grid[row + 1][col] = 2;
            }
            if(col > 0 && grid[row][col - 1] == 1){
                queue.offer(new orange(row, col - 1, layer + 1));
                grid[row][col - 1] = 2;
            }
            if(col < grid[0].length - 1 && grid[row][col + 1] == 1){
                queue.offer(new orange(row , col + 1, layer + 1));
                grid[row][col + 1] = 2;
            }
        }
        if(badOrangeNum == orangeNum){
            return time;
        }
        else{
            return -1;
        }
    }

    class orange{
        int row;
        int col;
        int layer;

        public orange(int row, int col, int layer) {
            this.row = row;
            this.col = col;
            this.layer = layer;
        }
    }
}

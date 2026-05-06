package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int result = 0;
        int[] recordX = new int[grid[0].length];
        int[] recordY = new int[grid[0].length];
        for(int i = 0;i < grid.length; ++i){
            int countX=  0;
            int countY = 0;
            for(int j = 0;j < grid[0].length; ++j){
                if(grid[i][j] == 'X'){
                    recordX[j] += 1;
                }else if(grid[i][j] == 'Y'){
                    recordY[j] += 1;
                }
                countX += recordX[j];
                countY += recordY[j];

                if(countX >= 1 && countX == countY){
                    result += 1;
                }
            }
        }
        return result;
    }
}

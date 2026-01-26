package com.zhn.personalproject.baseproject.leetcode;

public class Leetcode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int count = 0;

        for(int i = 0;i <= m + n - 2; ++i){
            if(i % 2 == 0){
                for(int j = Math.min(i, m - 1);j >= Math.max(0, i + 1 - n); --j){
                    // System.out.println(count);
                    result[count] = mat[j][i - j];
                    count += 1;
                }
            }
            else{
                for(int j = Math.min(i, n - 1);j >= Math.max(0, i + 1 - m); --j){
                    result[count] = mat[i - j][j];
                    count += 1;
                }
            }
        }
        return result;
    }
}

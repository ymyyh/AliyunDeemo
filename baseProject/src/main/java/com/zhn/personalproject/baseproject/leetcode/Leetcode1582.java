package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;

public class Leetcode1582 {
    public int numSpecial(int[][] mat) {
        int[] arr1 = new int[mat.length];
        int[] arr2 = new int[mat[0].length];
        Arrays.fill(arr1, 0);
        Arrays.fill(arr2, 0);

        for(int i = 0;i < mat.length; ++i){
            for(int j = 0;j < mat[0].length; ++j){
                if(mat[i][j] == 1){
                    arr1[i] += 1;
                    arr2[j] += 1;
                }
            }
        }

        int result = 0;
        for(int i = 0;i < mat.length; ++i){
            for(int j = 0;j < mat[0].length; ++j){
                if(arr1[i] == 1 && arr2[j] == 1 && mat[i][j] == 1){
                    result += 1;
                }
            }
        }

        return result;
    }
}

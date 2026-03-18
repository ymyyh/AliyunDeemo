package com.zhn.personalproject.baseproject.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1727 {
    public int largestSubmatrix(int[][] matrix) {
        int count = 0;
        int[][] record = new int[matrix.length][matrix[0].length];
        for(int j = 0;j < matrix[0].length; ++j){
            count = 0;
            for(int i = 0;i < matrix.length; ++i){
                if(matrix[i][j] == 0){
                    count = 0;
                }else{
                    count += 1;
                }
                record[i][j] = count;
            }
        }

        int result = 0;
        for(int i = 0;i < record.length; ++i){
            Integer[] temp = Arrays.stream(record[i]).boxed().toArray(Integer[]::new);
            Arrays.sort(temp, (a, b) -> b - a);
            for(int j = 0;j < temp.length; ++j) {
                if (temp[j] != 0) {
                    result = Math.max(result, temp[j] * (j + 1));
                }else{
                    break;
                }
            }
        }

        return result;
    }
}

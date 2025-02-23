package com.zhn.personalproject.baseproject.leetcode;

import java.util.*;

public class Leetcode1329 {
    public int[][] diagonalSort(int[][] mat) {
        int row;
        int column;
        int temp;
        for(int i = 0;i < mat.length; ++i){
            for(int j = 0;j < mat[0].length; ++j){
                if(i >= j){
                    row = mat.length - 1;
                    column = row - i + j;
                }
                else{
                    column = mat[0].length - 1;
                    row = column - j + 1;
                }
                while(row >= i + 1 && column >= j + 1){
                    if(mat[row][column] < mat[row - 1][column - 1]){
                        temp = mat[row][column];
                        mat[row][column] = mat[row - 1][column - 1];
                        mat[row - 1][column - 1] = temp;
                    }
                    row -= 1;
                    column -= 1;
                }
            }
        }
        return mat;
    }
}
